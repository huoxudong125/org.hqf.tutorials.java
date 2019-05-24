package org.hqf.java.staticProxy;



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

public class HelloServiceGrainProcessor {
    public String sayHello(String str) {
        return "HelloConcrete: " + str;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;

}
