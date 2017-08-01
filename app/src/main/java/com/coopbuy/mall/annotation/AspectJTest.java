package com.coopbuy.mall.annotation;

import android.content.Context;
import android.util.Log;

import com.coopbuy.mall.utils.ToastUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author wangyu
 * @time 2017/7/21 0021 on 下午 12:38
 * @desc
 */

@Aspect
public class AspectJTest {

    private static final String TAG = "tag00";

    /**
     * 切点
     */
    @Pointcut("execution(@com.coopbuy.mall.annotation.AspectAnnotation * *(..))")
    public void executionAspectJ() {

    }

    /**
     * 切面
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("executionAspectJ()")
    public Object aroundAspectJ(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Log.e(TAG, "aroundAspectJ(ProceedingJoinPoint joinPoint)");
        AspectAnnotation aspectJAnnotation = methodSignature.getMethod().getAnnotation(AspectAnnotation.class);
        String value = aspectJAnnotation.value();
        Context context = (Context) joinPoint.getThis();
        if(value == null || value.equals("")){
            ToastUtils.toastShort( "输入格式不对");
            return null;
        }
        return joinPoint.proceed();
    }
}
