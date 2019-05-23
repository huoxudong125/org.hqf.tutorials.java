package org.hqf.java.staticProxy.extend;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Title: <br>
 * <p/>
 * <p>
 * Description: CGLIB动态代理
 * 1. 首先实现一个MethodInterceptor，方法调用会被转发到该类的intercept()方法。 <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/05/23
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("You said: " + Arrays.toString(args));
        return proxy.invokeSuper(obj, args);
    }


}
