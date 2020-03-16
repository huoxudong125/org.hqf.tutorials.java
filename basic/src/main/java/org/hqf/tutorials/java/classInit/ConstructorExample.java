package org.hqf.tutorials.java.classInit;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 * https://blog.csdn.net/justloveyou_/article/details/72466416
 * https://mp.weixin.qq.com/s?__biz=MzU3NjMyOTUzNw==&mid=2247484703&idx=1&sn=314a5ed42de9eaee30ede767fb0def12&chksm=fd14c731ca634e27afccda148f54f848eeeed4d679401516b03e6bf27da1ebd9cffc2e999d37&mpshare=1&scene=1&srcid=0329G8QkpVWfmCUamOfkI0Tl&key=78b2720e78341aa21a2caeb3f52246713494f19270bd9c58e3b50b7b3c220d1d16d22b3369762019b6bf78f1159a96371a8858a99841e1719c2e7a6db372c01a144977deecb050011627d287755bd72f&ascene=1&uin=MTMzMzE1MDgw&devicetype=Windows+7&version=62060833&lang=zh_CN&pass_ticket=YRPWYGxXm7m8HozXVjab3oRy1Hr1CMlHCzmmtZdMsPU%3D
 *
 * @author huoquanfu
 * @date 2019/06/14
 */
//父类
class Foo {
    int i = 1;

    Foo() {
        System.out.println(i);

        int x = getValue();
        System.out.println(x);

    }

    {
        i = 2;
    }

    protected int getValue() {
        return i;
    }
}

//子类
class Bar extends Foo {
    int j = 1;

    Bar() {
        j = 2;
    }

    {
        j = 3;
    }

    @Override
    protected int getValue() {
        return j;
    }
}

public class ConstructorExample {
    public static void main(String... args) {
        Bar bar = new Bar();
        System.out.println(bar.getValue());

    }
}

