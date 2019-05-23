package org.hqf.java.staticProxy.service.extend;

import org.hqf.java.staticProxy.service.HelloService;
import org.hqf.java.staticProxy.service.impl.HelloServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Title: JDK原生动态代理<br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/05/23
 */
public class StaticProxiedHelloService implements HelloService {

    private HelloService getHelloServiceProxy() {
        // 2. 然后在需要使用Hello的时候，通过JDK动态代理获取Hello的代理对象。
        HelloService hello = (HelloService) Proxy.newProxyInstance(
                getClass().getClassLoader(), // 1. 类加载器
                new Class<?>[]{HelloService.class}, // 2. 代理需要实现的接口，可以有多个
                new LogInvocationHandler(new HelloServiceImpl()));// 3. 方法调用的实际处理者
        return hello;
    }


    @Override
    public String sayHello(String str) {
        return getHelloServiceProxy().sayHello(str);
    }
}
