package org.hqf.tutorials.java.utils;

import org.springframework.beans.BeanUtils;

/**
 * @author huoquanfu
 * @Description
 * @date 2018/07/12
 */
public class SpringBeanUtils {

    public static void main(String[] args) {
        TestSameObject();
        TestDiffObjectWithInheritance();
        TestDiffObject();
    }

    private static void TestSameObject() {
        Pepole a = new Pepole();
        a.setName("Lily");
        a.setAge(1);
        Pepole b = new Pepole();
        BeanUtils.copyProperties(a, b);

        System.out.println("b = " + b.getName());
        System.out.println("b = " + b.getAge());
    }

    private static void TestDiffObjectWithInheritance() {
        Woman a = new Woman();
        a.setName("Lily");
        a.setAge(1);
        Man b = new Man();
        BeanUtils.copyProperties(a, b);

        System.out.println("Man b = " + b.getName());
        System.out.println("Man b = " + b.getAge());
    }

    private static void TestDiffObject() {
        Woman a = new Woman();
        a.setName("Lily");
        a.setAge(1);
        a.setBraSize("A");

        Employee b = new Employee();
        BeanUtils.copyProperties(a, b);

        System.out.println("Employee b = " + b.getName());
        System.out.println("Employee b = " + b.getAge());
        System.out.println("Employee b = " + b.getSalary());
    }


}

class Pepole {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Man extends Pepole {
    private boolean beardColor;

    public boolean isBeardColor() {
        return beardColor;
    }

    public void setBeardColor(boolean beardColor) {
        this.beardColor = beardColor;
    }
}

class Woman extends Pepole {
    private String braSize;

    public String isBraSize() {
        return braSize;
    }

    public void setBraSize(String braSize) {
        this.braSize = braSize;
    }
}

class Employee {
    private String name;
    private int age;
    private int salary;


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
