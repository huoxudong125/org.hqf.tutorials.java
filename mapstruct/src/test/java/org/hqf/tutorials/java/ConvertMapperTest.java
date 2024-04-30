package org.hqf.tutorials.java;

import static org.junit.jupiter.api.Assertions.*;

class ConvertMapperTest {

    @org.junit.jupiter.api.Test
    void convertAToB() {
        A a = new A();
        a.setName("Tom");

        B b = ConvertMapper.INSTANCE.convertAToB(a);
        System.out.println(b.getName());

        assertEquals("Tom", b.getName());
        System.out.println("Hello world!");

    }
}