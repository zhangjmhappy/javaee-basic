package com.happyghost.javapattern.chain;

/**
 * @author HappyGhost
 * @create 2018-11-24 21:57
 **/
public class Manager extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.3) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
