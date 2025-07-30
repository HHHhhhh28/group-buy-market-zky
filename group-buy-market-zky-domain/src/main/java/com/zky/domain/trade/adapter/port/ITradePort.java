package com.zky.domain.trade.adapter.port;

import com.zky.domain.trade.model.entity.NotifyTaskEntity;

/**
 * @author ：zky
 * @description：
 * @date ：2025/7/30 17:28
 */
public interface ITradePort {
    String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception;
}
