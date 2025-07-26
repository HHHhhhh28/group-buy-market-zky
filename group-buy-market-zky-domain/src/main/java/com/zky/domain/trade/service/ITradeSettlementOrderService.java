package com.zky.domain.trade.service;


import com.zky.domain.trade.model.entity.TradePaySettlementEntity;
import com.zky.domain.trade.model.entity.TradePaySuccessEntity;

/**
 * @author zky
 * @description 拼团交易结算服务接口
 * @create 2025-01-26 14:34
 */
public interface ITradeSettlementOrderService {

    /**
     * 营销结算
     * @param tradePaySuccessEntity 交易支付订单实体对象
     * @return 交易结算订单实体
     */
    TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity);

}
