package com.zky.types.design.framework.link.model1;

/**
 * @author zky
 * @description 略规则责任链接口
 * @create 2025-01-18 09:09
 */
public interface ILogicLink<T, D, R> extends ILogicChainArmory<T, D, R> {

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
