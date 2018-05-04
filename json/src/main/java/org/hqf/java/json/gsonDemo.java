package org.hqf.java.json;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/05/02
 */
public class gsonDemo {

    public static void main(String[] args) {

        Map<String,String> map=new HashMap<>();

        map.put("A","a1");
        map.put("B","b1");

        Gson gson=new Gson();
        String mapStr=gson.toJson(map);
        System.out.println("mapStr = " + mapStr);


        gson.fromJson(mapStr,Map.class);

    }


}
