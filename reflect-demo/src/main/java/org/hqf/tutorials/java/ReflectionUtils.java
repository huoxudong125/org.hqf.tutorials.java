package org.hqf.tutorials.java;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionUtils {
    public static <T> void printObjectProperties(T object, String... propertyNames) {
        Class<?> clazz = object.getClass();

        for (String propertyName : propertyNames) {
            try {
                Field field = clazz.getDeclaredField(propertyName);
                field.setAccessible(true);
                Object value = field.get(object);
                System.out.println(propertyName + ": " + value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void printListProperties(List<T> list, String... propertyNames) {
        for (T object : list) {
            printObjectProperties(object, propertyNames);
            System.out.println();
        }
    }

}