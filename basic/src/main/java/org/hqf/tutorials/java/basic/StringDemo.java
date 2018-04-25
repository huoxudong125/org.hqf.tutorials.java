package org.hqf.tutorials.java.basic;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/04/25
 */
public class StringDemo {
    public static void main(String[] args) {
        String nullStr=null;
        String formatedStr=String.format("null string output as [%s]",nullStr);

        System.out.println("nullStr = " + nullStr);
        System.out.println("formatedStr = " + formatedStr);
    }
}
