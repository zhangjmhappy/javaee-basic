package com.happyghost.string;

import java.util.StringTokenizer;

public class AppTest {
    public static void main(String[] args) {
        String userAgent = "xxx==jjj==yyy";
        StringTokenizer st = new StringTokenizer(userAgent,"==");
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            String ssss = st.nextToken();
            System.out.println(ssss);
        }
        System.out.println(st.countTokens());


        Byte a = 5;

        System.out.println(a == 5);

    }
}
