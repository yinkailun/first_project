package com.ik.service.callrobot.data;

/**
 * @author yinkailun
 * @description:数组
 * @date 2018-09-05 下午8:50
 */
public class Array<T> {

    //数组索引无语义，最好在有语义的情况下使用

    private int size;
    /**
     * 不允许泛型数组
     */
    private Object[] data;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    public Array(int capacity){
        data = new Object[capacity];
        size = 0;
    }

    public Array(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取size
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 末尾位置添加元素
     */
    private void addLast(T e){

        add(size,e);
    }
    /**
     * 首位位置添加元素
     */
    public void addFirst(T e){

        add(0,e);
    }

    /**
     * 末尾位置添加元素
     */
    public void add(T e){

        add(size,e);
    }

    /**
     * 根据下标添加数据
     * @param index
     * @param e
     */
    public void add(int index , T e){

//        数组已满
        if(size == data.length){
            throw new RuntimeException("Add failed, Array full.");
        }
        //数组元素需要紧密排列
        if(index < 0 || index > size){
            throw new RuntimeException("Add failed, index error.");
        }
        //需要逆序操作，否则数据会一直重复
        for(int i = size-1 ; i >= index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size=%d . capacity=%d",size,data.length));
        sb.append("[");
        for(int i=0; i<size;i++){
            sb.append(data[i]);
            if(i < size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
