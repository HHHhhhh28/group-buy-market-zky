package com.zky.types.design.framework.link.model2;


import com.zky.types.design.framework.link.model2.chain.BusinessLinkedList;
import com.zky.types.design.framework.link.model2.handler.ILogicHandler;

/**
 * @author zky
 * @description 链路装配
 * @create 2025-01-18 10:02
 */
public class LinkArmory<T, D, R> {

    private final BusinessLinkedList<T, D, R> logicLink;

    @SafeVarargs
    public LinkArmory(String linkName, ILogicHandler<T, D, R>... logicHandlers) {
        logicLink = new BusinessLinkedList<>(linkName);
        for (ILogicHandler<T, D, R> logicHandler: logicHandlers){
            logicLink.add(logicHandler);
        }
    }

    public BusinessLinkedList<T, D, R> getLogicLink() {
        return logicLink;
    }

}
