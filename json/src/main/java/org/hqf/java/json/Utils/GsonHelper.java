package org.hqf.java.json.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/06/11
 */
public class GsonHelper {
    public static String serailObj(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gsonBuilder.registerTypeAdapterFactory(EnumTypeAdapter.ENUM_FACTORY);

        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }
}
