package org.hqf.java.json.utils;

import com.google.gson.Gson;
import org.hqf.java.json.People;
import org.hqf.java.json.TitleTypeEnum;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GsonHelperTest {

    @Test
    public void serailObj() {
        Map<String,String> map=new HashMap<>();

        map.put("A","a1");
        map.put("B","b1");

        System.out.println("map = " + GsonHelper.serailObj(map));


        People p=new People();
        p.setAge(1);
        p.setName("hqf");
        p.setBornDate(new Date());
        p.setTitleType(TitleTypeEnum.Manager);

        System.out.println("p = " + GsonHelper.serailObj(p));

    }

    @Test
    public void deserialize() {
        String pJson=" {\n" +
                "  \"bornDate\": \"2018-06-11 18:52:50\",\n" +
                "  \"name\": \"hqf\",\n" +
                "  \"age\": 1,\n" +
                "  \"titleType\": 1\n" +
                "}";

        People p=GsonHelper.deserialize(pJson,People.class);
        System.out.println("p = " + p.getName());
        System.out.println("p = " + p.getTitleType());

    }
}