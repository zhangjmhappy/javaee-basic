package com.happyghost.basicjava.objectclone;

import lombok.Data;

@Data
public class Address implements Cloneable {

    private String addressName;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}