package com.happyghost.basicjava.objectclone;

import lombok.Data;

@Data
public class Person implements Cloneable {

    private String name;

    private Integer age;
    
    private Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person newPerson = (Person)super.clone();
        newPerson.address = (Address) this.address.clone();
        return newPerson;
    }
}