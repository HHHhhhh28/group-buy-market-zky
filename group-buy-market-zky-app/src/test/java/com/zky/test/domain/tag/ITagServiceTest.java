package com.zky.test.domain.tag;

import com.zky.domain.tag.adapter.repository.ITagRepository;
import com.zky.domain.tag.service.TagService;
import com.zky.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBitSet;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 人群标签服务测试
 * @create 2024-12-28 14:33
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ITagServiceTest {

    @Resource
    private TagService tagService;
    @Resource
    private IRedisService redisService;
    @Resource
    private ITagRepository repository;

    @Test
    public void test_tag_job() {
        tagService.execTagBatchJob("RQ_KJHKL98UU78H66554GFDV", "10001");
    }

    @Test
    public void test_get_tag_bitmap() {
        RBitSet bitSet = redisService.getBitSet("RQ_KJHKL98UU78H66554GFDV");
        // 是否存在
        log.info("xiaofuge 存在，预期结果为 true，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("xiaofuge")));
        log.info("gudebai 不存在，预期结果为 false，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("gudebai")));


    }


}
