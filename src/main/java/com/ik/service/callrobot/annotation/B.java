package com.ik.service.callrobot.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author yinkailun
 * @description:
 * @date 2018-09-11 下午5:23
 */
@DocumentB
public class B extends A{

    public static void main(String[] args) {
        Annotation[] annotation = B.class.getAnnotations();
        System.out.println(Arrays.toString(annotation));
        Annotation[] annotation1 = B.class.getDeclaredAnnotations();
        System.out.println(Arrays.toString(annotation1));
        System.out.println(B.class.isAnnotationPresent(DocumentA.class));
    }
}
