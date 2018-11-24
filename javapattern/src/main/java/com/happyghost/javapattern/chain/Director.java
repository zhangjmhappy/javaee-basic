package com.happyghost.javapattern.chain;

/**
 * 销售经理
 *
 * @author HappyGhost
 * @create 2018-11-24 22:00
 **/
public class Director extends PriceHandler{

    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.4) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
