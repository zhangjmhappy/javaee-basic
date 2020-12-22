package com.happyghost.basicjava.immutableclass;

import java.util.Date;

public class ImmutableClazzTest {

    public static void main(String[] args) {
        Date date = new Date();
        immutableClazz immutableClazz = new immutableClazz(date);
        immutableClazz.printState();
        date.setMonth(5);
        immutableClazz.printState();
    }

}

class immutableClazz {
    private Date date;

    public immutableClazz(Date date) {
//        this.date = date;
        this.date = (Date)date.clone();
    }

    public void printState() {
        System.out.println(date);
    }
}
