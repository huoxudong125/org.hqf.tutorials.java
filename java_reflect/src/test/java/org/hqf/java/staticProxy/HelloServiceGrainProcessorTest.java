package org.hqf.java.staticProxy;

import net.sf.cglib.proxy.Enhancer;
import org.hqf.java.staticProxy.extend.MyMethodInterceptor;
import org.junit.Test;

public class HelloServiceGrainProcessorTest {

    @Test
    public void sayHello() {
        // 2. 然后在需要使用HelloConcrete的时候，通过CGLIB动态代理获取代理对象。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceGrainProcessor.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloServiceGrainProcessor hello = (HelloServiceGrainProcessor) enhancer.create();
        String str = "I love you!";
        System.out.println("inputValue = " + str);
        String result = hello.sayHello(str);
        System.out.println("result=" + result);

    }
}