package cn.itcast.file.demo1;

import java.util.LinkedList;

/**
 * 队列结构。先进先出。
 */
public class Queue<E> {
    private LinkedList<E> linkedList;

    /**
     * 提供了构造队列对象的构造器。
     */
    public Queue(){
        linkedList = new LinkedList<>();
    }
    /*
    * 添加元素的方法
    * */

    public void myAdd(E e){
        linkedList.addFirst(e);
    }
    /*
    * 获取元素的方法
    * */
    public E myGet(){
        return this.linkedList.removeLast();
    }
    /*
    * 判断队列是否有元素
    * */
    public boolean isNull(){
        return this.linkedList.isEmpty();
    }
}
