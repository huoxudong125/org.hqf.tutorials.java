package org.hqf.tutorial.java.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

public class ClassA {
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClassA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    public void setId(int id) {
        this.id = id;
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

    public List<ClassB> getItems() {
        return items;
    }

    public void setItems(List<ClassB> items) {
        this.items = items;
    }

    private int id;
    private String name;
    private int age;

    @XStreamAlias("classBs")
    private List<ClassB> items;
}
