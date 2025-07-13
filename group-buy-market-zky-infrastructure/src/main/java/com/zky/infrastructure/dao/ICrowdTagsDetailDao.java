package com.zky.infrastructure.dao;

import com.zky.infrastructure.dao.po.CrowdTagsDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/12 18:17
 */
@Mapper
public interface ICrowdTagsDetailDao {
    void addCrowdTagsUserId(CrowdTagsDetail crowdTagsDetailReq);
}

