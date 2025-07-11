package com.zky.domain.activity.adapter.repository;

import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zky.domain.activity.model.valobj.SkuVO;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 18:08
 */
public interface IActivityRepository  {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);

}

