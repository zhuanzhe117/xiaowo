package com.xiaowo.jdkLearning;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gu.haiyan on 2017/10/10.
 */
public class TestCollection {

    public static void main(String[] args)
    {

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2);
        System.out.println(i3==i4);


        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);

        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!


        for (Person person : set)
        {
            System.out.println(person.hashCode());
        }

        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
        for (Person person : set)
        {
            System.out.println(person.hashCode());
        }
        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set)
        {
            System.out.println(person);
        }
    }

}
class Person{
    private String name;

    private String pwd;

    private int age;

    private Person(){}
    public Person(String name,String pwd,int age){
        this.name= name;
        this.pwd = pwd;
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}