package com;


import java.lang.reflect.Field;
import java.util.Date;

public class test1 {
    public static void main(String[] args) throws Throwable{
        //1.实例化一个Person对象
        User per1=new User();
        per1.setUsername("dahuang1");

        //2.获取Person的类对象
        Class<User> perClass=User.class;
        //3.获取一个指定的对象用一下------->public修饰的
        Field ageField=perClass.getDeclaredField("username");
        //4.设置该属性可操作性
        ageField.setAccessible(true);

        //6.获取属性值
        Object value=ageField.get(per1);
        System.out.println(value);
    }
}
