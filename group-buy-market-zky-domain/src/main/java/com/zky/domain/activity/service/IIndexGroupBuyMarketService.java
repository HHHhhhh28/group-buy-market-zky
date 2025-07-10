package com.zky.domain.activity.service;

import com.zky.domain.activity.model.entity.MarketProductEntity;
import com.zky.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @author zky
 * @description 首页营销服务接口
 * @create 2024-12-14 13:39
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
