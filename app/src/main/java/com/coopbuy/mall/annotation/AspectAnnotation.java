package com.coopbuy.mall.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangyu
 * @time 2017/7/21 0021 on 下午 12:59
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AspectAnnotation {
    String value();
}
