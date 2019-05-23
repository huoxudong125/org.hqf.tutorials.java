package org.hqf.java.dynamicProxy.jdk.extend;

import org.hqf.java.dynamicProxy.jdk.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Title: <br>
 * <p/>
 * Description:  Java Proxy
 * 1. 首先实现一个InvocationHandler，方法调用会被转发到该类的invoke()方法。 <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/05/23
 */
public class LogInvocationHandler implements InvocationHandler {

    private HelloService helloService;

    public LogInvocationHandler(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if ("sayHello".equals(method.getName())) {
            System.out.println("======== " );
            System.out.println("You said: " + Arrays.toString(args));
            System.out.println("You are inspected : " + Arrays.toString(args)+" ha ha");
            System.out.println("======== " );
        }

        return method.invoke(helloService, args);
    }
}
