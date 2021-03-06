package org.hqf.tutorials.java.basic;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/05/25
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html">基础类型</a>
 */
public class ByteDemo {
    public static void main(String[] args) {

        Byte b=Byte.parseByte("127");
        System.out.println("b = " + b);

        Byte a = (byte) 1;
        System.out.println("a = " + a);
        changeByte(a);
        System.out.println("after changeByte(a), a= " + a);
        Byte c=Byte.parseByte("1");
        changeByte(c);
        System.out.println("after changeByte(c), c= " + c);

        System.out.println("由于缓存问题，a==c "+(a.equals(c)));
        System.out.println("a.eaual(c) "+a.equals(c));


        DemoA demoA1 =new DemoA();
        demoA1.setYn((byte)1);
        DemoB demoB1 =new DemoB();
        demoB1.setYn(Byte.parseByte("1"));
        System.out.println("demoA1==demoB1 "+(demoA1.getYn().equals(demoB1.getYn())));
        System.out.println("demoA1.eaual(demoB1)  "+demoA1.getYn().equals(demoB1.getYn()));

    }

    private static void changeByte(Byte b) {
        //TODO
        b++;
        System.out.println("b = " + b);

    }


}

class DemoA {
    Byte yn;

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }

}
class DemoB {
    Byte yn;

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }
}




