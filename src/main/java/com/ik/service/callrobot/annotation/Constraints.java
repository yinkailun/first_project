package com.ik.service.callrobot.annotation;

public @interface Constraints {

    //非空约束
    boolean allowNull() default false;

    //主键约束
    boolean isPrimaryKey() default false;

    //唯一性约束
    boolean unique() default false;
}
