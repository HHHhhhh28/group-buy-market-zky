package com.zky.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/14 16:51
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TagScopeEnumVO {

    VISIBLE(true, false, "是否可以看见拼团"),
    ENABLE(true, false, "是否可以参与拼团"),
    ;
    private boolean allow;
    private boolean refuse;
    private String desc;
}

