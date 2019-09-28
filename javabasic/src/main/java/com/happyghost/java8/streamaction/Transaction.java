package com.happyghost.java8.streamaction;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author HappyGhost
 * @create 2019-09-27 0:18
 **/
@Data
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
