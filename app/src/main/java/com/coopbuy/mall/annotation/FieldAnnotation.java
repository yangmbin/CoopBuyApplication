package com.coopbuy.mall.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author wangyu
 * @time 2017/7/21 0021 on 上午 11:25
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FieldAnnotation {

    //是否可以为空
    boolean nullable() default false;

    //参数或者字段描述,这样能够显示友好的异常信息
    String descripString() default "";
}
