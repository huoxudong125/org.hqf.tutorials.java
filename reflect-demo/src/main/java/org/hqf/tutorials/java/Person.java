package org.hqf.tutorials.java;

import lombok.Data;

// 示例实体类
@Data
public class Person {
    private String name;
    private int age;
    private String occupation;

    public Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }


}
