package com.happyghost.java8;

/**
 * @author HappyGhost
 * @create 2019-04-09 2:19
 **/

public class UserModel {

    private String name;

    private int age;

    private String sex;

    private boolean city;

    private Integer salary;

    public UserModel() {

    }

    public boolean isCity() {
        return city;
    }

    public void setCity(boolean city) {
        this.city = city;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public UserModel(String name, int age, String sex,Integer salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
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
