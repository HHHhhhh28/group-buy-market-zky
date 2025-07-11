package com.zky.infrastructure.dao;

import com.zky.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/10 18:29
 */
@Mapper
public interface ISkuDao {
    Sku querySkuByGoodsId(String goodsId);
}

