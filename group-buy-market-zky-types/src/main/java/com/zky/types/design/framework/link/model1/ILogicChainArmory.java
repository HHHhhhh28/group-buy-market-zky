package com.zky.types.design.framework.link.model1;

/**
 * @author zky
 * @description 责任链装配
 * @create 2025-01-18 09:10
 */
public interface ILogicChainArmory<T, D, R> {

    ILogicLink<T, D, R> next();

    ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next);

}
