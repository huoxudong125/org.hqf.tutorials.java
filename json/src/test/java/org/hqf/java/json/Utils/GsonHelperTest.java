package org.hqf.java.json.Utils;

import org.hqf.java.json.People;
import org.hqf.java.json.TitleTypeEnum;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

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
}