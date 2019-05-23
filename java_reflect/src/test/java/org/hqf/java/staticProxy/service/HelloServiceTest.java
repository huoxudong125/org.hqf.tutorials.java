package org.hqf.java.staticProxy.service;

import org.hqf.java.staticProxy.service.extend.StaticProxiedHelloService;
import org.junit.Test;

public class HelloServiceTest {

    @Test
    public void testSayHello() {

        HelloService helloService = new StaticProxiedHelloService();
        String name = "Frank";
        System.out.println("input value = " + name);
        String result = helloService.sayHello(name);
        System.out.println("result = " + result);
    }
}