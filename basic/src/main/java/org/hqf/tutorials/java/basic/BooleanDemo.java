package org.hqf.tutorials.java.basic;

public class BooleanDemo {

    public static void main(String[] args) {
        Byte shortageReceiveFlag = 1;
        boolean boolValue = Boolean.parseBoolean(shortageReceiveFlag.toString());
        System.out.println("boolValue = " + boolValue);

        boolValue = !shortageReceiveFlag.equals(0);
        System.out.println("boolValue = " + boolValue);

//        shortageReceiveFlag=null;
//        boolValue = !shortageReceiveFlag.equals(0);
//        System.out.println("boolValue = " + boolValue);


        Boolean nullBoolean=null;
        System.out.println("nullBoolean = " + Boolean.FALSE.equals(nullBoolean));
        System.out.println("nullBoolean = " + Boolean.TRUE.equals(nullBoolean));


    }
}


