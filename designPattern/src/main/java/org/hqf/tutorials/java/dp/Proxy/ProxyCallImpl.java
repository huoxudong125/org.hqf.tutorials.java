package org.hqf.tutorials.java.dp.Proxy;

public class ProxyCallImpl implements Call {

    private final CallImpl realCaller;

    public ProxyCallImpl() {
        realCaller = new CallImpl();

    }

    @Override
    public void doAction() {
        System.out.println("Prepare call process");
        realCaller.doAction();
        System.out.println("Finish call process.");
    }


}
