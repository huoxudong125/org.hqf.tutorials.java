package org.hqf.tutorials.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huoquanfu
 * @date 2019/02/18
 */
public class MapDemo {

    private static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        testBoolean();
    }

    private static void testBoolean() {
        map.put("A", true);

        System.out.println("map.boolean = " + map.get("A"));
        Boolean aBoolean1 = map.get(null);
        System.out.println("map.nullBool = " + aBoolean1);
        // will throw Exception,
        boolean aBoolean = map.get(null);
        System.out.println("map.nullBool = " + aBoolean);
    }
}
