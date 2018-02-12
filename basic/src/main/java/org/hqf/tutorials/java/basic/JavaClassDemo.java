package org.hqf.tutorials.java.basic;

/**
 * @author huoquanfu
 */
public class JavaClassDemo {

    public static String getCallerFunctionName(){
       return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
