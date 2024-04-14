package com.test;

import pojo.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        Class<Student> c = Student.class;
        Method method = c.getDeclaredMethod("add", int.class, int.class);
        Object n = method.invoke(student,1,2);
        System.out.println(n);
    }
}
