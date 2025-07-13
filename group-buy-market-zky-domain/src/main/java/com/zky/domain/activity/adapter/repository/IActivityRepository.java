package com.zky.domain.activity.adapter.repository;

import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zky.domain.activity.model.valobj.SCSkuActivityVO;
import com.zky.domain.activity.model.valobj.SkuVO;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 18:08
 */
public interface IActivityRepository  {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityByGoodsId(String source, String channel, String goodsId);
}

