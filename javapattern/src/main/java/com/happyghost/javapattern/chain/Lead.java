package com.happyghost.javapattern.chain;

/**
 * 销售主管
 *
 * @author HappyGhost
 * @create 2018-11-24 22:24
 **/
public class Lead extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.15) {
            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
