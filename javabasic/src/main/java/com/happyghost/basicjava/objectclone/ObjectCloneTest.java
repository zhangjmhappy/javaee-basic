package com.happyghost.basicjava.objectclone;

import org.junit.Test;

/**
 * 为什么阿里Java手册推荐慎用 Object 的 clone 方法来拷贝对象
 *https://juejin.cn/post/6844903903943720967
 */
public class ObjectCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {

//        test01();
//        test02();
    }

    /**
     * 对象的
     *
     * @throws CloneNotSupportedException
     */
    @Test
    public  void test01() throws CloneNotSupportedException {
        Person person = new Person();
        person.setName("Happyjava");
        person.setAge(33);
        Address address = new Address();
        address.setAddressName("浙江杭州");
        person.setAddress(address);
        Person newPerson = (Person) person.clone();
        System.out.println(person == newPerson);//false
        System.out.println(person.getAddress() == newPerson.getAddress());//true,重写Person类中的clone方法为false
    }

    /**
     * 出现地址对象应该用
     * @throws CloneNotSupportedException
     */
    @Test
    public  void test02() throws CloneNotSupportedException {
        Person person = new Person();
        person.setName("Happyjava");
        person.setAge(33);
        Address address = new Address();
        address.setAddressName("浙江杭州");
        person.setAddress(address);
        Person newPerson = (Person) person.clone();
        newPerson.getAddress().setAddressName("广东深圳");

        System.out.println(person.getAddress().getAddressName());//广东深圳
    }


}
