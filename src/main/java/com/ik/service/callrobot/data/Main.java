package com.ik.service.callrobot.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinkailun
 * @description:main
 * @date 2018-09-05 下午9:53
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array(20);
        for(int i = 0 ; i < 10 ; i++){
            array.add(i);
        }
        array.add(1,100);
        array.addFirst(-1);
        System.out.println(array);

        List<Integer> list = new ArrayList<>();
        System.out.println(15>>1);
    }
}
