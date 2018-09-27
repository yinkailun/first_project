package com.ik.service.callrobot.tree;


import java.util.*;

/**
 * @author yinkailun
 * @description:二分搜索树
 * @date 2018-09-26 下午7:38
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node{

        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        root = add(root , e);
    }

    private Node add(Node node, E e) {
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else if(e.compareTo(node.e) < 0){
            return contains(node.right,e);
        }else{
            return true;
        }
    }


    public void preOrder(){
        preOrder(root,0);
    }

    /**
     * 前序遍历
     */
    private void preOrder(Node node,int deep) {
        if(node == null){
            return;
        }
        System.out.println(printDeep(deep)+node.e);
        preOrder(node.left,deep+1);
        preOrder(node.right,deep+1);
    }

    /**
     * 前序遍历非递归实现
     * 使用栈结构
     */
    private void preOrderNoRecursion() {

        Stack<Node> stack = new Stack<>();
        if(root != null)
            stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            //栈结构后进先出，所以先推入右子树，再推入左子树
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }

    }

    /**
     * 前序遍历和终须遍历逻辑相同，只是访问节点时机不同
     * 先存入当前节点
     * 转左子树
     * 直到结束
     * 取出栈顶元素
     * 转右子树
     *
     */
    public void preOrderNoRecursion2() {
         Stack<Node> stack = new Stack<>();
         Node node = root;
         // 将所有左孩子压栈
         while (node != null || stack.size() > 0) {
             // 压栈之前先访问
             if (node != null) {
                 //压入栈之前访问元素
                 System.out.println(node.e);
                 stack.push(node);
                 node = node.left;

             } else {
                 node = stack.pop();
                 node = node.right;
             }
         }
    }
    /**
     * 中序遍历非递归实现
     * 使用栈结构
     */
    private void midOrderNoRecursion() {

        Stack<Node> stack = new Stack<>();
        Node node = root;
        // 将所有左孩子压栈
        while (node != null || stack.size() > 0) {
            // 压栈之前先访问
            if (node != null) {
                stack.push(node);
                node = node.left;

            } else {
                node = stack.pop();
                //因为一直往下查找左子树，所以先输出的为左子树，然后取出当前节点，输出当前节点
                System.out.println(node.e);
                node = node.right;
            }
        }

    }
    /**
     * 后序遍历非递归实现
     * 使用栈结构
     * 使用额外栈存储输出结果，因为要先输出左，再输出右，因此遍历的时候先存储node.right
     */
    private void lastOrderNoRecursion() {

        Stack<Node> stack = new Stack<>();
        //存储输出结果
        Stack<Node> output = new Stack<>();
        Node node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (output.size()>0){
            System.out.println(output.pop().e);
        }

    }

    public void midOrder(){
        midOrder(root,0);
    }
    /**
     * 中序遍历
     * @param node
     * @param deep
     */
    private void midOrder(Node node,int deep) {
        if(node == null){
            return;
        }

        midOrder(node.left,deep+1);
        System.out.println(printDeep(deep)+node.e);
        midOrder(node.right,deep+1);
    }

    public List toCollectionAsc(){
        List list = new ArrayList(size);
        return toCollectionAsc(root,list);
    }

    /**
     * 使用中序遍历获取从小到达排序的一个集合
     * @param node
     * @param list
     */
    private List toCollectionAsc(Node node, List list) {
        if(node == null){
            return null;
        }

        toCollectionAsc(node.left,list);
        list.add(node.e);
        toCollectionAsc(node.right,list);
        return list;
    }
    public List toCollectionDesc(){
        List list = new ArrayList(size);
        return toCollectionDesc(root,list);
    }

    /**
     * 使用中序遍历获取从大到小排序的一个集合
     * @param node
     * @param list
     */
    private List toCollectionDesc(Node node, List list) {
        if(node == null){
            return null;
        }

        toCollectionDesc(node.right,list);
        list.add(node.e);
        toCollectionDesc(node.left,list);
        return list;
    }


    public void lastOrder(){
        lastOrder(root,0);
    }
    /**
     * 后序遍历,把数据从小到大排序
     * @param node
     * @param deep
     */
    private void lastOrder(Node node,int deep) {
        if(node == null){
            return;
        }

        lastOrder(node.left,deep+1);
        lastOrder(node.right,deep+1);
        System.out.println(printDeep(deep)+node.e);
    }

    private String printDeep(int deep){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<deep;i++){
            sb.append("--");
        }
        return sb.toString();
    }

    /**
     * 广度优先遍历/层序遍历
     * 使用队列
     * @return
     */
    public void levelOrder(){
        Queue<Node> queue = new ArrayDeque<>();
        Node node = root;
        while(node != null || queue.size() > 0){
            System.out.println(node.e);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            node = queue.poll();
        }
    }
    @Override
    public String toString(){

        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        /**
         *      3
         *    /   \
         *  2     65
         *       /   \
         *     21    87
         *    /  \   /
         *  14   32 66
         *  /
         * 12
         * /
         * 9
         */
        List<Integer> a = Arrays.asList(3,2,65,21,32,14,87,12,9,66);
        //添加操作
        a.forEach(c -> tree.add(c));
        System.out.println("******前序遍历");
        tree.preOrder();
        System.out.println("******中序遍历");
        tree.midOrder();
        System.out.println("******后序遍历");
        tree.lastOrder();
        //测试使用中序遍历获取从小到大排序的list
        System.out.println(tree.toCollectionAsc());
        //测试使用中序遍历获取从大到小排序的list
        System.out.println(tree.toCollectionDesc());
        //前序、中序、后序为深度优先遍历
        //前序非递归
        tree.preOrderNoRecursion();
        //前序非递归
        tree.preOrderNoRecursion2();
        //中序非递归
        tree.midOrderNoRecursion();
        //后序非递归
        tree.lastOrderNoRecursion();
        //广度优先遍历、层序遍历
        tree.levelOrder();
    }
}
