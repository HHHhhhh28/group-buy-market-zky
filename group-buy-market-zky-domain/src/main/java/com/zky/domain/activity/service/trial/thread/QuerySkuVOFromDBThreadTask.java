package com.zky.domain.activity.service.trial.thread;

import com.zky.domain.activity.adapter.repository.IActivityRepository;
import com.zky.domain.activity.model.valobj.SkuVO;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.Callable;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 19:29
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }
}

