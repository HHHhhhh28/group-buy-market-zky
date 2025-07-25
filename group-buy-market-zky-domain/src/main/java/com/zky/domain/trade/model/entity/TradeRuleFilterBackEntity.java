package com.zky.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zky
 * @description 拼团交易，过滤反馈实体
 * @create 2025-01-25 14:16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRuleFilterBackEntity {

    // 用户参与活动的订单量
    private Integer userTakeOrderCount;

}
