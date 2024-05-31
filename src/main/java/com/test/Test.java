package com.test;

import pojo.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Student> c = Student.class;
        Field field = c.getDeclaredField("stuid");
        System.out.println(field.getName()+ Modifier.toString(field.getModifiers())+field.getType());
//        Field field1 = c.getField("stuid");得到自己和父类的public属性
        Student student = new Student();
        field.setAccessible(true);//设置私有属性可以访问
        field.set(student,1);
        System.out.println(student.getStuid());

    }
}
