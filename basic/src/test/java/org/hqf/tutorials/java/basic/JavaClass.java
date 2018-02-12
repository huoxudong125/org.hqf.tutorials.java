package org.hqf.tutorials.java.basic;

import org.junit.Test;

public class JavaClass {

    @Test
    public void getClassName (){

        Class<? extends JavaClass> aClass = this.getClass();
        System.out.println(String.format("this.simple className [%s]", aClass.getName()));
        System.out.println(String.format("this.simple classSimpleName [%s]", aClass.getSimpleName()));
        System.out.println(String.format("this.simple classTypeName [%s]", aClass.getTypeName()));
    }


    @Test
    public void testGetCallerFunctionName(){
       String funName=JavaClassDemo.getCallerFunctionName();
        System.out.println("funName = " + funName);
    }

}
