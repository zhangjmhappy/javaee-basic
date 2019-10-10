package com.happyghost.regx;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxDemo {

    @Test
    public void testDemo() {
        Pattern pattern = Pattern.compile("Java \\d");
        String candidate = "Java 4";
        Matcher matcher = pattern.matcher(candidate);
        if (matcher != null) {
            System.out.println(matcher.find());
        }
    }

    @Test
    public void matchAnyWord() {
        Pattern pattern = Pattern.compile("\\w+");
        String candidate = "hello world www.baidu.com";
        Matcher matcher = pattern.matcher(candidate);
        if (matcher.find()) {
            System.out.println("Group 0:" + matcher.group(0));
        }
    }


    @Test
    public void patternDemo() {
        Pattern pattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        String candidate = "Java. java JAVA jAVA";
        Matcher matcher = pattern.matcher(candidate);

        //display
        System.out.println(candidate);
        matcher.find(11);
        System.out.println(matcher.group());

        System.out.println(candidate);
        matcher.find(0);
        System.out.println(matcher.group());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void matchStartAndEndMethod() {
        String regex = "[a-z]@.";
        Pattern pattern = Pattern.compile(regex);
        String candidateStr = "abc@yahoo.com,123@cnn.com,abc@goole.com";
        Matcher matcher = pattern.matcher(candidateStr);
        while (matcher.find()) {
            String foundStr = candidateStr.substring(matcher.start(), matcher.end());
            System.out.println(foundStr);
        }
    }

//    public void match
}
