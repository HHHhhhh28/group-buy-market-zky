package com.zky.domain.activity.service.discount;

import com.zky.domain.activity.model.valobj.DiscountTypeEnum;
import com.zky.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/11 18:25
 */
public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService {


    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())) {
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange) {
                return originalPrice;
            }
        }
        return doCalculate(originalPrice,groupBuyDiscount);
    }


    private boolean filterTagId(String userId, String tagId) {
        return true;
    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

    protected BigDecimal ensureMinimumPrice(BigDecimal price) {
        if (price.compareTo(new BigDecimal("0.01")) < 0) {
            return new BigDecimal("0.01");
        }
        return price;
    }

}

