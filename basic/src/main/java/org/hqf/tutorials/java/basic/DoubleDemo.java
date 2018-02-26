package org.hqf.tutorials.java.basic;

public class DoubleDemo {

    public static void main(String[] args) {
        String doubleStr="1";
        double doubleValue=Double.parseDouble(doubleStr);

        System.out.println("doubleValue = " + doubleValue);

        doubleStr=".1";
        doubleValue=Double.parseDouble(doubleStr);

        System.out.println("doubleValue = " + doubleValue);


        doubleStr="";
        doubleValue=Double.parseDouble(doubleStr);

        System.out.println("doubleValue = " + doubleValue);
    }

}
