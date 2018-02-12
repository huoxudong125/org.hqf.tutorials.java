package org.hqf.tutorials.java.basic;


import java.util.concurrent.CountDownLatch;

public class ExceptionDemo {

    public static void printExceptionInfo(Exception ex){
        //获取调用者的类名
        String className =ex.getStackTrace()[1].getClassName();

        //获取调用者的方法名
        String methodName =ex.getStackTrace()[1].getMethodName();


        System.out.println(String.format("className [%s] ,method_name [%s] " ,className, methodName));
    }

    public static void rethrowException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // 该行就成了异常的新发生地！
            throw (RuntimeException) e.fillInStackTrace();
        }
    }

    public static void rethrowNewException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // 该行就成了异常的新发生地！
            throw e;
        }
    }

    public static void main (String[] args) {
//        try {
//            ExceptionDemo.rethrowException();
//        } catch (Exception e) {
////            System.out.println("e = " + e);
//            e.printStackTrace();
//        }


        try {
            ExceptionDemo.rethrowNewException();
        } catch (Exception e) {
            e.printStackTrace();

            printExceptionInfo(e);
        }
    }

}
