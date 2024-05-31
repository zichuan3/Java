package com.test;

import pojo.Student;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c =Class.forName("pojo.Student");
        Student student = (Student) c.newInstance();
        System.out.println(c.getSuperclass());
        System.out.println(Arrays.toString(c.getInterfaces()));
    }
}
