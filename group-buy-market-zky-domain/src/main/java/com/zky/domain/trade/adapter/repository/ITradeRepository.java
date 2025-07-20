package com.zky.domain.trade.adapter.repository;

import com.zky.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.zky.domain.trade.model.entity.MarketPayOrderEntity;
import com.zky.domain.trade.model.valobj.GroupBuyProgressVO;

/**
 * @author zky
 * @description 交易仓储服务接口
 * @create 2025-01-11 09:07
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

}
