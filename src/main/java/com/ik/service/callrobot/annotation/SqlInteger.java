package com.ik.service.callrobot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yinkailun
 * @description:
 * @date 2018-09-11 下午5:46
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlInteger {
    String name() default "";
    int length() default 0;
    Constraints constraints() default @Constraints;
}
