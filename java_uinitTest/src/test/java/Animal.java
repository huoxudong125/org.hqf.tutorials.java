/**
 * @author huoquanfu
 * @Description
 * @date 2018/07/12
 */
public class Animal {
    private String name = "default name";

    public String sayHello(String hiStr) {

        String msg = hiStr + " " + name;
        System.out.println("msg = " + msg);
        return msg;
    }

    public String getName() {
        return name;
    }

    public String getFixValue() {
        return "fixed value";
    }

}
