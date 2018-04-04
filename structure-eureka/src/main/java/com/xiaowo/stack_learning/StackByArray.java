package com.xiaowo.stack_learning;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by gu.haiyan on 2018/4/2.
 * 通过数组实现栈
 */
public class StackByArray<Item> implements Iterable<Item> {
    private Item[] a; //数组表示栈
    private int n;    //栈内元素个数

    /**
     * 初始化一个空栈
     */
    public StackByArray(){
        a = (Item[]) new Object[2];
        n = 0;
    }

    /**
     * 判断栈内是否有元素
     * @return
     */
    public boolean isEmpty(){
        return n == 0;
    }

    /**
     * 返回栈内元素个数
     */
    public int size(){
        return n;
    }

    // 改变栈的大小
    public void resize(int capacity){
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i =0;i < n; i++){
            temp[i] = a[i];
        }
        a = temp;
//        a = Arrays.copyOf(a,capacity);
    }

    /**
     * 压入元素
     */
    public void push(Item item){
       if (n == a.length)
           resize(2*a.length);
       a[n++] = item;
    }
    /**
     * 弹出并返回元素
     */
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;
        n--;
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    /**
     * 返回但不弹出栈顶元素
     */
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }

    /**
     * 返回一个可以进行先进后出迭代的迭代器
     */
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    // 用内部类实现迭代器接口，实现从栈顶往栈底的先进后出迭代，没有实现remove()方法
    private class ReverseArrayIterator implements Iterator<Item>{

        private int i;
        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
          return i >= 0;
        }

        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        StackByArray<String> stack = new StackByArray<>();
        stack.push("11");
        stack.push("12");
//        stack.pop();
        System.out.print(stack.size());
    }
}
