package org.hqf.tutorials.java.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionDemoTest {

    @Test
    public void rethrowException() {
        try {
            ExceptionDemo.rethrowException();
        } catch (Exception e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        }

    }

    @Test
    public void rethrowNewException() {
        try {
            ExceptionDemo.rethrowNewException();
        } catch (Exception e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        }
    }
}