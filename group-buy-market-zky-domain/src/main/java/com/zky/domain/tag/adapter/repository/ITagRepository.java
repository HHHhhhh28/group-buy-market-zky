package com.zky.domain.tag.adapter.repository;

import com.zky.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/12 18:46
 */
public interface ITagRepository {
    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    void addCrowdTagsUserId(String tagId, String userId);

    void updateCrowdTagsStatistics(String tagId, int size);
}

