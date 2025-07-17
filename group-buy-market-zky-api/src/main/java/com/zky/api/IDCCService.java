package com.zky.api;

import com.zky.api.response.Response;

/**
 * @author : zky
 * @description : DCC 动态配置中心
 * @createDate : 2025/7/16 17:33
 */
public interface IDCCService {
    Response<Boolean> updateConfig(String key, String value);

}

