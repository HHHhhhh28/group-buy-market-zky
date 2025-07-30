package com.zky.domain.trade.adapter.repository;

import com.zky.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.zky.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import com.zky.domain.trade.model.entity.GroupBuyActivityEntity;
import com.zky.domain.trade.model.entity.GroupBuyTeamEntity;
import com.zky.domain.trade.model.entity.MarketPayOrderEntity;
import com.zky.domain.trade.model.entity.NotifyTaskEntity;
import com.zky.domain.trade.model.valobj.GroupBuyProgressVO;

import java.util.List;

/**
 * @author zky
 * @description 交易仓储服务接口
 * @create 2025-01-11 09:07
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    boolean settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList();

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList(String teamId);


    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);
}
