package org.hqf.java.doc;

/**
 * 类的说明
 * <p>
 * javadocDemo 类演示如何生成类的API文档<br>
 *
 * @author hqf
 * @version 1.0 ldd 2017.3.11
 * </p>
 */
public class JavaDemo {
    /*对于类的公有属性，也要写上相关注释*/
    /**
     * 用于显示一个提示信息
     */
    public final String message = "this is a demo for javadocument.";

    /**
     * 这个方法是程序入口，虚拟机载入这个类的时候，
     * 将从这个类开始运行程序
     *
     * @param args commandlines<br>
     */
    public static void main(String[] args) {
        JavaDemo demo = new JavaDemo();
        System.out.println(demo.message);
        System.out.print(demo.upcaseMessage());
        System.out.print(demo.getChars(2, 6));
    }


    /**
     * 打印信息
     *
     * @param message 要打印的消息
     * @param ynEnum 是否打印的枚举
     */
    public void print(String message, YnEnum ynEnum) {
        if (YnEnum.YES.getCode().equals(ynEnum.getCode())) {
            System.out.println("message = " + message);
        } else {
            System.out.println("不允许输出");
        }
    }


    /**
     * 从message中获取指定的字串
     *
     * @param i  子串的开始下标
     * @param i1 子串的结束目标
     * @return 从开始到结束的子串
     */
    private String getChars(int i, int i1) {
        return message.substring(i, i1);
    }

    /**
     * 将message转化成大写的字符串
     *
     * @return 大写的字符串
     */
    private String upcaseMessage() {
        return message.toUpperCase();
    }

}
