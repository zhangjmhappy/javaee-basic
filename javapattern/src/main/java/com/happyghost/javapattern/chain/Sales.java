package com.happyghost.javapattern.chain;

/**
 * 销售，可以批准5%的折扣
 * @author HappyGhost
 * @create 2018-11-24 21:52
 **/
public class Sales extends PriceHandler{

    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.05) {

            System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
        } else {
            successor.processDiscount(discount);
        }
    }
}
