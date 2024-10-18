package org.hqf.tutorials.java;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.setName("Tom");
        B b = ConvertMapper.INSTANCE.convertAToB(a);
        System.out.println(b.getName());

        System.out.println("Hello world!");
    }
}