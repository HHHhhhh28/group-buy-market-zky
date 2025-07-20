package com.zky.api;

import com.zky.api.dto.LockMarketPayOrderRequestDTO;
import com.zky.api.dto.LockMarketPayOrderResponseDTO;
import com.zky.api.response.Response;

/**
 * @author zky
 * @description 营销交易服务接口
 * @create 2025-01-11 13:49
 */
public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);

}
