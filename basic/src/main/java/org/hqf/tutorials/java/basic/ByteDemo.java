package org.hqf.tutorials.java.basic;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/05/25
 */
public class ByteDemo {
    public static void main(String[] args) {


        Byte a = (byte) 1;
        System.out.println("a = " + a);
        changeByte(a);
        System.out.println("after changeByte(a), a= " + a);

    }

    private static void changeByte(Byte b) {
        //TODO
        b++;
        System.out.println("b = " + b);
    }

}




