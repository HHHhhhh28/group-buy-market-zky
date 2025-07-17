package com.zky.types.annotations;

import java.lang.annotation.*;

/**
 * @author : zky
 * @description : 注解，动态配置中心标记
 * @createDate : 2025/7/14 21:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {
    //DCC:dynamic config controller
    String value() default "";
}

