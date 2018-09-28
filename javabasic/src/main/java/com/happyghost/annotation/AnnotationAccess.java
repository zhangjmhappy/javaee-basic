package com.happyghost.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationAccess {


    private static void printClassPrintAnnation(Class clazz) {
        if (clazz.isAnnotationPresent(AuthorAnnotation.class)) {
            AuthorAnnotation aa = (AuthorAnnotation) clazz.getAnnotation(AuthorAnnotation.class);
            System.out.println("作者：" + aa.name() + "," + aa.compnay());
        }
    }

    private static void printConstructAnnation(Class clazz) {
        System.out.println("======构造方法如下======");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor constructor = declaredConstructors[i];
            if (constructor.isAnnotationPresent(ConstructorAnnotation.class)) {
                ConstructorAnnotation annotation = (ConstructorAnnotation) constructor.getAnnotation(ConstructorAnnotation.class);
                System.out.println(constructor.getName() + "." + annotation.value());
            }
            Annotation[][] parameterAnnotation = constructor.getParameterAnnotations();
            printParameterAnnotation(parameterAnnotation);
        }
    }

    private static void printParameterAnnotation(Annotation[][] parameterAnnotation) {
        System.out.println("参数长度：" + parameterAnnotation.length);
        for (int i = 0; i < parameterAnnotation.length; i++) {
            int length = parameterAnnotation[i].length;
            System.out.println("参数长度111：" + length);
            if (length == 0) {
                System.out.println("    未添加Annotation注解");
            }else{
                for (int j = 0; j < length ; j++) {
                    CommonAnnotation pa = (CommonAnnotation)parameterAnnotation[i][j];
                    System.out.print("第"+(i + 1) + "个参数：  " + pa.description());
                    System.out.println("    " + pa.type());
                }
            }
        }
        System.out.println();
    }

    private static void printFiledAnnotation(Class clazz) {
        System.out.println("======成员变量如下======");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            if (field.isAnnotationPresent(CommonAnnotation.class)) {
                CommonAnnotation fa = field.getAnnotation(CommonAnnotation.class);
                System.out.print("成员变量：" + field.getName() + "  " + fa.description());
                System.out.println("    " + fa.type());
            }
        }
        System.out.println();
    }

    private static void printMethodAnnotation(Class clazz) {
        System.out.println("======方法描述如下======");
        Method[] declaredMethods= clazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            if (method.isAnnotationPresent(CommonAnnotation.class)) {
                CommonAnnotation ma = method.getAnnotation(CommonAnnotation.class);
                System.out.println("成员方法：" + method.getName() + "：  " + ma.description());
                System.out.println("返回类型：" + ma.type());
            }

            Annotation[][] parameterAnnotation = method.getParameterAnnotations();
            printParameterAnnotation(parameterAnnotation);
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        Class personClass = Class.forName("com.happyghost.annotation.Person");
        printClassPrintAnnation(personClass);
        printConstructAnnation(personClass);
        printFiledAnnotation(personClass);
        printMethodAnnotation(personClass);
    }




}
