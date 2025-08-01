package com.zky.domain.activity.adapter.repository;

import com.zky.domain.activity.model.entity.UserGroupBuyOrderDetailEntity;
import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zky.domain.activity.model.valobj.SCSkuActivityVO;
import com.zky.domain.activity.model.valobj.SkuVO;
import com.zky.domain.activity.model.valobj.TeamStatisticVO;

import java.util.List;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 18:08
 */
public interface IActivityRepository  {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityByGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowdRange(String tagId, String userId);

    boolean downgradeSwitch();

    boolean cutRange(String userId);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByOwner(Long activityId, String userId, Integer ownerCount);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByRandom(Long activityId, String userId, Integer randomCount);

    TeamStatisticVO queryTeamStatisticByActivityId(Long activityId);
}

