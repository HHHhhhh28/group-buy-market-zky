package com.zky.domain.trade.service.lock.filter;

import com.zky.domain.trade.adapter.repository.ITradeRepository;
import com.zky.domain.trade.model.entity.GroupBuyActivityEntity;
import com.zky.domain.trade.model.entity.TradeLockRuleCommandEntity;
import com.zky.domain.trade.model.entity.TradeLockRuleFilterBackEntity;
import com.zky.domain.trade.service.lock.factory.TradeLockRuleFilterFactory;
import com.zky.types.design.framework.link.model2.handler.ILogicHandler;
import com.zky.types.enums.ActivityStatusEnumVO;
import com.zky.types.enums.ResponseCode;
import com.zky.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/22 6:55
 */
@Slf4j
@Service
public class ActivityUsabilityRuleFilter implements ILogicHandler<TradeLockRuleCommandEntity, TradeLockRuleFilterFactory.DynamicContext, TradeLockRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;
    @Override
    public TradeLockRuleFilterBackEntity apply(TradeLockRuleCommandEntity requestParameter, TradeLockRuleFilterFactory.DynamicContext dynamicContext) throws Exception {

        log.info("交易规则过滤-活动的可用性校验{} activityId:{}", requestParameter.getUserId(), requestParameter.getActivityId());
        GroupBuyActivityEntity groupBuyActivity = repository.queryGroupBuyActivityEntityByActivityId(requestParameter.getActivityId());
        if(!ActivityStatusEnumVO.EFFECTIVE.equals(groupBuyActivity.getStatus())){
            throw new AppException(ResponseCode.E0101);
        }
        Date currentTime = new Date();

        if(currentTime.before(groupBuyActivity.getStartTime()) || currentTime.after(groupBuyActivity.getEndTime())){
            throw new AppException(ResponseCode.E0102);
        }
        dynamicContext.setGroupBuyActivity(groupBuyActivity);
        return next(requestParameter, dynamicContext);
    }
}

