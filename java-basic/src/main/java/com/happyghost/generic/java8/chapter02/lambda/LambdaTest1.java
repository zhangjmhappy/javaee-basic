package com.happyghost.generic.java8.chapter02.lambda;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HappyGhost
 * @create 2018-09-16 13:46
 **/
public class LambdaTest1 {

    public static void main(String[] args){

//        String s = () -> "sxxxx";

        try {
            String s = processFile();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String processFile() throws IOException {

        String com_path = LambdaTest1.class.getClassLoader().getResource("./").getPath();
        System.out.println(com_path);
        try (BufferedReader br = new BufferedReader(new FileReader(com_path+"data.txt"))) {
            return br.readLine();
        }
    }


}
