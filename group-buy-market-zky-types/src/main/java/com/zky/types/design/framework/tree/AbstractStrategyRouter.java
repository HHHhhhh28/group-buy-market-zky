package com.zky.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 11:47
 */
public abstract class AbstractStrategyRouter<T,D,R>implements StrategyMapper<T,D,R>,StrategyHandler<T,D,R> {
    @Getter
    @Setter
    protected StrategyHandler<T,D,R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception{
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if(strategyHandler != null){
            return strategyHandler.apply(requestParameter,dynamicContext);
        }
        return defaultStrategyHandler.apply(requestParameter,dynamicContext);
    }
}

