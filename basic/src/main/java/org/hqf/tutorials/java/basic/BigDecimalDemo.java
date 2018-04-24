package org.hqf.tutorials.java.basic;

import java.math.BigDecimal;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/04/23
 */
public class BigDecimalDemo {

    public static void main(String[] args) {

        Double doubleMax = Double.MAX_VALUE;
        BigDecimal doubleMaxDecimal = new BigDecimal(doubleMax);
        System.out.println("doubleMax = " + doubleMax);
        System.out.println("doubleMaxDecimal = " + doubleMaxDecimal);

        Double doubleMin = Double.MIN_VALUE;
        BigDecimal doubleMinDecimal = new BigDecimal(doubleMin);
        System.out.println("doubleMin = " + doubleMin);
        System.out.println("doubleMaxDecimal = " + doubleMinDecimal);

        BigDecimal bigDecimal = new BigDecimal("0.1");
        System.out.println("bigDecimal = " + bigDecimal);

        double weight = 12345678901234567.123;
        BigDecimal bigDecimalWeight = new BigDecimal(weight);
        System.out.println("weight = " + weight);
        System.out.println("bigDecimalWeight = " + bigDecimalWeight);


        double volume=12345678901234.123456;
        BigDecimal bigDecimalVolume=new BigDecimal(volume);
        System.out.println("volume = " + volume);
        System.out.println("bigDecimalVolume = " + bigDecimalVolume);


        convertError();


    }

    private static void convertError() {
        String strEmpty="";
        BigDecimal bigDecimalEmpty=new BigDecimal(strEmpty);
        System.out.println("bigDecimal1 = " + bigDecimalEmpty);

        String str=null;
        BigDecimal bigDecimal1=new BigDecimal(str);
        System.out.println("bigDecimal1 = " + bigDecimal1);
    }




}
