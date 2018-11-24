package com.happyghost.javapattern.chain;

import com.happyghost.javapattern.chain.*;

/**
 * @author HappyGhost
 * @create 2018-11-24 22:29
 **/
public class PriceHandlerFactory {
    /**
     * 创建PriceHandler的工厂方法
     * @return
     */
    public static PriceHandler createPriceHandler() {
        PriceHandler sales = new Sales();
        PriceHandler lead = new Lead();//新增的lead
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler ceo = new CEO();

        sales.setSuccessor(lead);
        lead.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(ceo);
        return sales;
    }
}
