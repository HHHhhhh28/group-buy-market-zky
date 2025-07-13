package com.zky.domain.activity.service.trial.thread;

import com.zky.domain.activity.adapter.repository.IActivityRepository;
import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.zky.domain.activity.model.valobj.SCSkuActivityVO;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 19:03
 */
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    /**
     * 来源
     */
    private final String source;

    /**
     * 渠道
     */
    private final String channel;

    private final String goodsId;

    /**
     * 活动仓储
     */
    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel,String goodsId, IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        SCSkuActivityVO scSkuActivityVO = activityRepository.querySCSkuActivityByGoodsId(source, channel,goodsId);
        if(scSkuActivityVO == null){
            return null;
        }
        return activityRepository.queryGroupBuyActivityDiscountVO(scSkuActivityVO.getActivityId());
    }
}

