package com.happyghost.annotation;

@AuthorAnnotation(name = "张三",compnay = "XX科技有限公司")
public class Person {

    @CommonAnnotation(type = String.class, description = "姓名")
    private String name;

    @CommonAnnotation(type = int.class ,description = "年龄")
    private int age;

    @ConstructorAnnotation
    public Person() {
        this("unknown",0);
    }

    @ConstructorAnnotation(value = "带参数的的构造方法")
    public Person(@CommonAnnotation(type = String.class,description = "姓名") String name,
                  @CommonAnnotation(type = int.class,description = "年龄") int age) {
        this.name = name;
        this.age = age;
    }

    @CommonAnnotation(type = String.class,description = "设置姓名")
    public String getName() {
        return name;
    }

    @CommonAnnotation(type = String.class,description = "获得姓名")
    public void setName(@CommonAnnotation(type = String.class,description = "姓名")String name) {
        this.name = name;
    }

    @CommonAnnotation(type = int.class,description = "设置年龄")
    public int getAge() {
        return age;
    }

    @CommonAnnotation(type = int.class,description = "获得年龄")
    public void setAge(@CommonAnnotation(type = int.class,description = "年龄")int age) {
        this.age = age;
    }
}
