package com.happyghost.java8;

/**
 * @author HappyGhost
 * @create 2019-04-09 2:19
 **/

public class UserModel {

    private String name;

    private int age;

    private String sex;

    public UserModel() {
    }

    public UserModel(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + "年龄" + this.age + "性别" + this.sex;
    }

}
