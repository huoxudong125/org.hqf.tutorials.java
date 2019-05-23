package org.hqf.java.dynamicProxy.jdk.impl;

import org.hqf.java.dynamicProxy.jdk.service.HelloService;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Company:
 *
 * @author huoquanfu
 * @date 2019/05/23
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }

}
