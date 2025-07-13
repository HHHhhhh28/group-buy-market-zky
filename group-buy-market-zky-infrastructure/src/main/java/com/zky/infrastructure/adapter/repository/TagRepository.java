package com.zky.infrastructure.adapter.repository;

import com.zky.domain.tag.adapter.repository.ITagRepository;
import com.zky.domain.tag.model.entity.CrowdTagsJobEntity;
import com.zky.infrastructure.dao.ICrowdTagsDao;
import com.zky.infrastructure.dao.ICrowdTagsDetailDao;
import com.zky.infrastructure.dao.ICrowdTagsJobDao;
import com.zky.infrastructure.dao.po.CrowdTags;
import com.zky.infrastructure.dao.po.CrowdTagsDetail;
import com.zky.infrastructure.dao.po.CrowdTagsJob;
import com.zky.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBitSet;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zky
 * @description 人群标签仓储
 * @create 2024-12-28 13:12
 */
@Slf4j
@Repository
public class TagRepository implements ITagRepository {

    @Resource
    private ICrowdTagsDao crowdTagsDao;
    @Resource
    private ICrowdTagsDetailDao crowdTagsDetailDao;
    @Resource
    private ICrowdTagsJobDao crowdTagsJobDao;

    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {
        CrowdTagsJob crowdTagsJobReq = new CrowdTagsJob();
        crowdTagsJobReq.setTagId(tagId);
        crowdTagsJobReq.setBatchId(batchId);

        CrowdTagsJob crowdTagsJobRes = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJobReq);
        if (null == crowdTagsJobRes) return null;

        return CrowdTagsJobEntity.builder()
                .tagType(crowdTagsJobRes.getTagType())
                .tagRule(crowdTagsJobRes.getTagRule())
                .statStartTime(crowdTagsJobRes.getStatStartTime())
                .statEndTime(crowdTagsJobRes.getStatEndTime())
                .build();
    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {
        CrowdTagsDetail crowdTagsDetailReq = new CrowdTagsDetail();
        crowdTagsDetailReq.setTagId(tagId);
        crowdTagsDetailReq.setUserId(userId);

        try {
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetailReq);

            // 获取BitSet
            RBitSet bitSet = redisService.getBitSet(tagId);
            boolean set = bitSet.set(redisService.getIndexFromUserId(userId), true);

        } catch (DuplicateKeyException e) {
            log.warn("userId: {} 已存在，忽略重复插入", userId);
        } catch (Exception e) { // 捕获所有其他异常
            log.error("执行数据库操作时发生异常，导致后续代码终止", e);
        }
    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int count) {
        CrowdTags crowdTagsReq = new CrowdTags();
        crowdTagsReq.setTagId(tagId);
        crowdTagsReq.setStatistics(count);

        crowdTagsDao.updateCrowdTagsStatistics(crowdTagsReq);
    }

}
