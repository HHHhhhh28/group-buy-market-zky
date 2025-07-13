package com.zky.infrastructure.dao;

import com.zky.infrastructure.dao.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/13 19:38
 */
@Mapper
public interface ISCSkuActivityDao {
    SCSkuActivity querySCSkuActivityByGoodsId(SCSkuActivity scSkuActivity);
}

