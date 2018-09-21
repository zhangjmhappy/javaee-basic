package com.happyghost.annotation;

public class AnnotationAccess {

    /**
     *
     * @param clazz
     */
    private static void printClassPrintAnnation(Class clazz) {
        if (clazz.isAnnotationPresent(AuthorAnnotation.class)) {
            AuthorAnnotation aa = (AuthorAnnotation) clazz.getAnnotation(AuthorAnnotation.class);
            System.out.println("作者：" + aa.name() + "," + aa.compnay());
        }
    }

    private static void printConstructAnnation(Class Clazz) {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class personClass = Class.forName("com.happyghost.annotation.Person");
        printClassPrintAnnation(personClass);
    }


}
