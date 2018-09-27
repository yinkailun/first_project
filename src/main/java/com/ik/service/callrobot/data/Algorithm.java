package com.ik.service.callrobot.data;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yinkailun
 * @description:Insertion-sort
 * 插入排序
 * @date 2018-09-16 下午4:36
 */
public class Algorithm {

    /**
     * @description 插入排序
     * 时间复杂度 O(n^2)
     * 由小到大排序,这里面的操作不是替换操作，因为替换是操作两个元素，这种只讲较大元素后移，当遍历结束后，才将当前元素放到指定位置
     * 实现：从左到右遍历，每次取出当前index元素，若比前面的元素小，则替换，
     * 若比前面元素大，则不作操作，选取下一个index元素
     *
     */
    public static <T extends Comparable> T[] insertionSort(T[] ary){
        int count = 0;//记录数据移动次数
        for(int i = 1 ; i < ary.length ; i++){
            T cur = ary[i];//当前元素
            int j = i;
            while(j > 0 && ary[j-1].compareTo(cur) > 0){
                ary[j] = ary[j-1];
                j --;
                count ++;
//                ary[j--] =
            }
            ary[j] = cur;
        }
        System.out.println("执行次数："+count);
        return ary;
    }

    /**
     * 生成PseudoRandom 伪随机数
     * @param end
     */
    public static void nextInt(int end){
        int cur = 1;
        int a= 3;
        int b =7;
        //生成10次
        for(int i = 0 ; i < 10 ; i ++){
            cur = (a * cur + b) % end;
            System.out.println(cur);
        }
    }

    public static void main(String[] args) {

        //插入排序测试
//        Integer [] a = new Integer[10000];
//        for(int i = 0 ; i < 10000 ; i++){
//            a[i] = (Integer) RandomUtils.nextInt(0,Integer.MAX_VALUE);
//        }
//        System.out.println(Arrays.toString(insertionSort(a)));
        //生成伪随机数
//        nextInt(100);
        //Tic-Tac_Toe游戏；二位数组 two-dimensional arrays
    }

}
