package com.happyghost.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HappyGhost
 * @create 2019-08-24 3:01
 **/
public class TestMain {
    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);
    public static void main(String[] args) {
        logger.info("xxxxxxxxxxxxx");
        logger.debug("11111{}","hello");
    }
}
