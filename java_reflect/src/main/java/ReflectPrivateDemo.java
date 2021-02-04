import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huoquanfu
 * @Description
 * @date 2018/07/12
 * @see <a href=https://stackoverflow.com/questions/34571/how-do-i-test-a-private-function-or-a-class-that-has-private-methods-fields-or>
 * 如何测试私有方法</a>
 */
public class ReflectPrivateDemo {


    public static void main(String[] args) {

        ClassDemo cls = new ClassDemo();
        Class c = cls.getClass();

        try {
            // parameter type is null
            Method m = c.getDeclaredMethod("show", null);
            m.setAccessible(true);
            System.out.println("method = " + m.toString());
            System.out.println("i = " + m.invoke(cls).toString());

            // method Integer
            Class[] cArg = new Class[1];
            cArg[0] = Integer.class;
            Method lMethod = c.getDeclaredMethod("showInteger", cArg);
            //关键的一步，否则无法访问私有方法
            lMethod.setAccessible(true);
            System.out.println("method = " + lMethod.toString());
            //void 方法返回null
            System.out.println("i = " + lMethod.invoke(cls,0));


            //访问私有private 字段
            Field field = c.getDeclaredField("i");
            field.setAccessible(true);
            field.set(cls, 100);

            //访问私有private 字段
            field = c.getField("j");
            field.setAccessible(true);
            field.set(cls, 200);

            System.out.println("j= " + cls.toString());




        } catch (NoSuchMethodException e) {
            System.out.println(e.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}

class ClassDemo {
    private Integer show() {
        System.out.println("i = " + i);
        return i;
    }

    private void showInteger(Integer i) {
        this.i = i;
        System.out.println("i = " + i);
    }

    private int i = 78655;

    public int j;

    @Override
    public String toString() {
        return "ClassDemo{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}