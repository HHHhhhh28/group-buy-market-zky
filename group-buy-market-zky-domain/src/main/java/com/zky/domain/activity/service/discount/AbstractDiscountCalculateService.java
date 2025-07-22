package com.zky.domain.activity.service.discount;

import com.zky.domain.activity.adapter.repository.IActivityRepository;
import com.zky.domain.activity.model.valobj.DiscountTypeEnum;
import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/11 18:25
 */
@Slf4j
public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService {


    @Resource
    protected IActivityRepository repository;
    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())) {
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange) {
                log.info("折扣优惠计算拦截，用户不再优惠人群标签范围内 userId:{}", userId);

                return originalPrice;
            }
        }
        return doCalculate(originalPrice,groupBuyDiscount);
    }


    private boolean filterTagId(String userId, String tagId) {
        return repository.isTagCrowdRange(tagId, userId);
    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

    protected BigDecimal ensureMinimumPrice(BigDecimal price) {
        if (price.compareTo(new BigDecimal("0.01")) < 0) {
            return new BigDecimal("0.01");
        }
        return price;
    }

}

