package org.hqf.tutorials.java.basic;

import org.junit.Test;

public class JavaClass {

    @Test
    public void getClassName (){

        System.out.println(String.format("this.simple className [%s]",this.getClass().getName()));
        System.out.println(String.format("this.simple classSimpleName [%s]",this.getClass().getSimpleName()));
        System.out.println(String.format("this.simple classTypeName [%s]",this.getClass().getTypeName()));
    }

}
