package com.zky.types.design.framework.tree;

/**
 * @author : zky
 * @description : 策略映射器
 * @createDate : 2025/7/10 10:19
 */
public interface StrategyMapper<T,D,R> {
    StrategyHandler<T,D,R> get(T requestParameter,D dynamicContext) throws Exception;
}

