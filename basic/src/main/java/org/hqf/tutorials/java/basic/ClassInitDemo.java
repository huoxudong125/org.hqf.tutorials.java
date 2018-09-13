package org.hqf.tutorials.java.basic;

/**
 * @author huoquanfu
 * @date 2018/09/13
 */
public class ClassInitDemo {
    public static void main(String[] args) {
        System.out.println("A.staticStrA = " + A.staticStrA);
        System.out.println("A.staticStrA = " + B.staticStrB);
    }

}


 class A{
    public static final String staticStrA="staticStrA";

    static {
        System.out.println("Class A Static init");
    }
}



class B{
    static {
        System.out.println("Class B Static init");
    }

    public static final String staticStrB="staticStrB";
}




