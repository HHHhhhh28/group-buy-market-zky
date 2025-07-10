package com.zky.domain.activity.service.trial.node;

import com.zky.domain.activity.model.entity.MarketProductEntity;
import com.zky.domain.activity.model.entity.TrialBalanceEntity;
import com.zky.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.zky.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.zky.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 13:38
 */
@Slf4j
@Service
public class MarketNode   extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }
}

