package org.hqf.tutorials.java.basic;

/**
 * @author huoquanfu
 * @date 2018/09/13
 */
public class ClassInitDemo {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("A.staticStrA = " + A.staticStrA);
        System.out.println();
        System.out.println("B.staticStrB = " + B.staticStrB);
        System.out.println();
        System.out.println("C.staticStrC = " + C.staticStrC);
        System.out.println();
        System.out.println("C2.staticStrP = " + C2.staticStrP);
        System.out.println();

    }

}


class A {
    public static final String staticStrA = "staticStrA";

    static {
        System.out.println("Class A Static init");
    }
}


class B {
    static {
        System.out.println("Class B Static init");
    }

    public static final String staticStrB = new String("staticStrB");
}

class P {
    static {
        System.out.print("P");
    }
}

class C extends P {
    static {
        System.out.print("C");
    }

    public final static String staticStrC = "C";
}

class P2 {
    public  static String staticStrP = "staticStrP2";

    static {
        System.out.print("P2");
    }
}

class C2 extends P2 {

    static {
        System.out.print("C2");
    }
}





