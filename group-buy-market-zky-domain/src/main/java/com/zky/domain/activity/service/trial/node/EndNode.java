package com.zky.domain.activity.service.trial.node;

import com.alibaba.fastjson.JSON;
import com.zky.domain.activity.model.entity.MarketProductEntity;
import com.zky.domain.activity.model.entity.TrialBalanceEntity;
import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zky.domain.activity.model.valobj.SkuVO;
import com.zky.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.zky.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zky.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 13:41
 */
@Slf4j
@Service
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-EndNode userId:{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));

        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();
        SkuVO skuVO = dynamicContext.getSkuVO();
        BigDecimal deductionPrice = dynamicContext.getDeductionPrice();
        BigDecimal payPrice = dynamicContext.getPayPrice();
        // 返回空结果
        return TrialBalanceEntity.builder()
                .goodsId(skuVO.getGoodsId())
                .goodsName(skuVO.getGoodsName())
                .originalPrice(skuVO.getOriginalPrice())
                .deductionPrice(deductionPrice)
                .payPrice(payPrice)
                .targetCount(groupBuyActivityDiscountVO.getTarget())
                .startTime(groupBuyActivityDiscountVO.getStartTime())
                .endTime(groupBuyActivityDiscountVO.getEndTime())
                .isVisible(dynamicContext.isVisible())
                .isEnable(dynamicContext.isEnable())
                .groupBuyActivityDiscountVO(groupBuyActivityDiscountVO)
                .build();
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }
}

