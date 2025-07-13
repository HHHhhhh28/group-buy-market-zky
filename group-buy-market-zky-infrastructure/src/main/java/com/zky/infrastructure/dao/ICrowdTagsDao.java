package com.zky.infrastructure.dao;

import com.zky.infrastructure.dao.po.CrowdTags;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/12 18:16
 */
@Mapper
public interface ICrowdTagsDao {
    void updateCrowdTagsStatistics(CrowdTags crowdTagsReq);
}

