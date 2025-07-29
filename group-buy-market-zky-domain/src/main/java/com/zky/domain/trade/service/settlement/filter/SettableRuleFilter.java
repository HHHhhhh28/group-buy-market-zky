package com.zky.domain.trade.service.settlement.filter;

import com.zky.domain.trade.adapter.repository.ITradeRepository;
import com.zky.domain.trade.model.entity.GroupBuyTeamEntity;
import com.zky.domain.trade.model.entity.MarketPayOrderEntity;
import com.zky.domain.trade.model.entity.TradeSettlementRuleCommandEntity;
import com.zky.domain.trade.model.entity.TradeSettlementRuleFilterBackEntity;
import com.zky.domain.trade.service.settlement.factory.TradeSettlementRuleFilterFactory;
import com.zky.types.design.framework.link.model2.handler.ILogicHandler;
import com.zky.types.enums.ResponseCode;
import com.zky.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zky
 * @description 可结算规则过滤；交易时间
 * @create 2025-01-29 09:38
 */
@Slf4j
@Service
public class SettableRuleFilter implements ILogicHandler<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradeSettlementRuleFilterBackEntity apply(TradeSettlementRuleCommandEntity requestParameter, TradeSettlementRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        log.info("结算规则过滤-有效时间校验{} outTradeNo:{}", requestParameter.getUserId(), requestParameter.getOutTradeNo());
        MarketPayOrderEntity marketPayOrderEntity = dynamicContext.getMarketPayOrderEntity();
        // 查询组团信息
        GroupBuyTeamEntity groupBuyTeamEntity = repository.queryGroupBuyTeamByTeamId(marketPayOrderEntity.getTeamId());
        Date outTradeTime = requestParameter.getOutTradeTime();
        if(!outTradeTime.before(groupBuyTeamEntity.getValidEndTime())) {
            throw new AppException(ResponseCode.E0106);
        }
        dynamicContext.setGroupBuyTeamEntity(groupBuyTeamEntity);
        return next(requestParameter, dynamicContext);


    }

}
