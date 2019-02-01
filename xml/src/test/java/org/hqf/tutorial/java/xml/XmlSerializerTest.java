package org.hqf.tutorial.java.xml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class XmlSerializerTest {

    private HashMap<String, Class> classAliasMap = new HashMap<String, Class>();
    ;

    @Before
    public void setUp() throws Exception {

        classAliasMap.put("A", ClassA.class);
        classAliasMap.put("A", ClassA.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deserialize() {

        String xmlStr = "<A>\n" +
                "  <id>2</id>\n" +
                "  <age>20</age>\n" +
                "  <name>hqf</name>\n" +
                "</A>";

        try {
            System.out.println("XmlSerializer.deserialize = " + XmlSerializer.deserialize(xmlStr, ClassA.class, classAliasMap).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void serialize() {
        ClassA a = new ClassA();
        a.setId(1);
        a.setAge(10);
        a.setName("hqf");

        System.out.println("XmlSerializer.serialize = " + XmlSerializer.serialize(a, classAliasMap));

    }


    @Test
    public void deserialize2() {

        String xmlStr = "<A>\n" +
                "  <id>2</id>\n" +
                "  <age>20</age>\n" +
                "  <name>hqf</name>\n" +
                "<classBs>" +
                "<classBAlias>" +
                "<classAliasField>alias</classAliasField>" +
                "<field>field</field>" +
                "</classBAlias>" +
                "</classBs>" +
                "</A>";

        try {
            Object deserialize = XmlSerializer.deserialize(xmlStr, ClassA.class, classAliasMap);
            System.out.println("XmlSerializer.deserialize = " + deserialize.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}