package org.hqf.tutorials.java.classInit;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 * 父类的类构造器<clinit>() -> 子类的类构造器<clinit>() -> 父类的成员变量和实例代码块 -> 父类的构造函数 -> 子类的成员变量和实例代码块 -> 子类的构造函数。
 *
 * @author huoquanfu
 * @date 2019/06/14
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    /**
     * 实例变量
     */
    int a = 110;

    /**
     * 静态变量
     */
    static int b = 112;
}

