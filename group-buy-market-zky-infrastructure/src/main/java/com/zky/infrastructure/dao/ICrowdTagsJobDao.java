package com.zky.infrastructure.dao;

import com.zky.infrastructure.dao.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/12 18:18
 */
@Mapper
public interface ICrowdTagsJobDao {
    CrowdTagsJob queryCrowdTagsJob(CrowdTagsJob crowdTagsJobReq);

}

