package com.zky.domain.trade.service.lock.filter;

import com.zky.domain.trade.adapter.repository.ITradeRepository;
import com.zky.domain.trade.model.entity.GroupBuyActivityEntity;
import com.zky.domain.trade.model.entity.TradeRuleCommandEntity;
import com.zky.domain.trade.model.entity.TradeRuleFilterBackEntity;
import com.zky.domain.trade.service.lock.factory.TradeRuleFilterFactory;
import com.zky.types.design.framework.link.model2.handler.ILogicHandler;
import com.zky.types.enums.ResponseCode;
import com.zky.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/22 9:09
 */
@Slf4j
@Service
public class UserTakeLimitRuleFilter implements ILogicHandler<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;

    @Override
    public TradeRuleFilterBackEntity apply(TradeRuleCommandEntity requestParameter, TradeRuleFilterFactory.DynamicContext dynamicContext) throws Exception {

        GroupBuyActivityEntity groupBuyActivity = dynamicContext.getGroupBuyActivity();

        log.info("交易规则过滤-用户参与次数校验{} activityId:{}", requestParameter.getUserId(), requestParameter.getActivityId());
        // 查询用户在一个拼团活动上参与的次数
        Integer count = repository.queryOrderCountByActivityId(requestParameter.getActivityId(), requestParameter.getUserId());

        if (null != groupBuyActivity.getTakeLimitCount() && count >= groupBuyActivity.getTakeLimitCount()) {
            throw new AppException(ResponseCode.E0103);
        }
        return TradeRuleFilterBackEntity.builder().userTakeOrderCount(count).build();
    }
}

