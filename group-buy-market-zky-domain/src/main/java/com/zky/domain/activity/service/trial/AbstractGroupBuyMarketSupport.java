package com.zky.domain.activity.service.trial;

import com.zky.domain.activity.adapter.repository.IActivityRepository;
import com.zky.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import com.zky.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 12:12
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity,DynamicContext,TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<MarketProductEntity,DynamicContext,TrialBalanceEntity> {
    protected long timeout = 500;
    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(MarketProductEntity requestParameter, DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
    }
}

