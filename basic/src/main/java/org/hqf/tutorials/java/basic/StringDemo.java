package org.hqf.tutorials.java.basic;


/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/04/25
 */
public class StringDemo {
    public static void main(String[] args) {
        String nullStr = null;
        String formatedStr = String.format("null string output as [%s]【%s】", nullStr, nullStr);

        System.out.println("nullStr = " + nullStr);
        System.out.println("formatedStr = " + formatedStr);


        String intergerStr="1";
        Integer integer=1;
        System.out.println("intergerStr.equals(integer) = " + intergerStr.equals(integer.toString()));
        System.out.println("intergerStr.equals(integer) = " + integer.equals(Integer.parseInt(intergerStr)));



    }
}
