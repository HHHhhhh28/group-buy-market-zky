package com.zky.types.design.framework.tree;

/**
 * @author : zky
 * @description : 策略处理器
 * T 入参类型
 * D 上下文参数
 * R 返参类型
 * @createDate : 2025/7/10 10:20
 */
public interface StrategyHandler<T, D, R> {
    StrategyHandler DEFAULT = (T,D) -> null;
    R apply(T requestParameter, D dynamicContext) throws Exception;
}

