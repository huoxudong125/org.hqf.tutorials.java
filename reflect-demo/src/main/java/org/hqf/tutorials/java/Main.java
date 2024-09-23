package org.hqf.tutorials.java;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Alice", 25, "Engineer");
        Person person2 = new Person("Bob", 30, "Teacher");
        Person person3 = new Person("Charlie", 35, "Doctor");

        // 单个实体的属性读取
        System.out.println("Single object properties:");
        ReflectionUtils.printObjectProperties(person1, "name", "age");
        System.out.println();

        System.out.println("Single object properties:");
        ReflectionUtils.printObjectProperties(person1, "age");
        System.out.println();


        // 实体列表的属性读取
        System.out.println("List properties:");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        ReflectionUtils.printListProperties(personList, "name", "occupation");
    }
}
