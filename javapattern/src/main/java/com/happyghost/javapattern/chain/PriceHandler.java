package com.happyghost.javapattern.chain;

/**
 * 价格处理人，负责处理客户折扣和申请
 * @author HappyGhost
 * @create 2018-11-24 21:47
 **/
public abstract class PriceHandler {

    /**
     * 直接后继，用于传递请求
     */
    PriceHandler successor;

    public PriceHandler getSuccessor() {
        return successor;
    }

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    public abstract void processDiscount(float discount);

}
