package org.hqf.tutorials.java.regex;

public class RegexDemo {


    private static final String SPLIT = "|";


    public static void main(String[] args) {
        String keyAndValue="Key"+SPLIT+"Value";

//        String[] strs=  keyAndValue.split("\\"+SPLIT);
        String[] strs=  keyAndValue.split(SPLIT);

        System.out.println("Key = " + strs[0]);
        System.out.println("Value = " + strs[1]);
    }

}
