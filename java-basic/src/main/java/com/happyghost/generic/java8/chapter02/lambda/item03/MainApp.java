package com.happyghost.generic.java8.chapter02.lambda.item03;

import com.happyghost.generic.java8.chapter02.lambda.LambdaTest1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HappyGhost
 * @create 2018-09-16 17:53
 **/
public class MainApp {

    public static void main(String[] args) throws IOException {

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        //String oneLine = processFile(BufferedReader::readLine);
        System.out.println(oneLine);

        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLine);


    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        String com_path = LambdaTest1.class.getClassLoader().getResource("./").getPath();
        System.out.println(com_path);
        try (BufferedReader br = new BufferedReader(new FileReader(com_path + "data.txt"))) {
            return bufferedReaderProcessor.process(br);
        }
    }
}
