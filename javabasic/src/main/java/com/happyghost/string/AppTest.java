package com.happyghost.string;

import org.junit.Test;

import java.util.Date;
import java.util.StringTokenizer;

public class AppTest {

    public static void main(String[] args) {
        String userAgent = "xxx==jjj==yyy";
        StringTokenizer st = new StringTokenizer(userAgent, "==");
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            String ssss = st.nextToken();
            System.out.println(ssss);
        }
        System.out.println(st.countTokens());


        Byte a = 5;

        System.out.println(a == 5);


    }


    @Test
    public void testTime() throws InterruptedException {
        Long beginTime = new Date().getTime();

        Thread.sleep(3000);

        Long endTime = new Date().getTime();

        Long costTime = endTime - beginTime;


        System.out.println(costTime / (1000*60));
    }

    @Test
    public void testFor() {
        Integer times = 0;
        for (int i = 0; i < times; i++) {
            System.out.println(i);
        }
        if (true) {

        }
        System.out.println(1111);

        String textname = "格伦巴赫洛兹沙滩女足";
        System.out.println(textname.indexOf("沙滩") );
    }
}
