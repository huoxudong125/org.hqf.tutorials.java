package org.hqf.tutorial.java.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class XmlSerializer {

    private static final String XML_PRE = "<";

    public static Object deserialize(String message, Class wmsReturnClass, Map map) throws Exception {

        if (message == null) {
            throw new Exception(" the param is not  allow   null !");
        } else if (!message.startsWith(XML_PRE)) {
            throw new Exception(" the param is not  XML !");
        }
        /** xml转换 */
        XStream xStream = new XStream(new DomDriver());
        xStream.ignoreUnknownElements();
        setClassAliasMap(map, xStream);
        return xStream.fromXML(message);
    }



    public static String serialize(Object obj,Map map) {
        XStream xStream = new XStream(new DomDriver());
        setClassAliasMap(map,xStream);
        return xStream.toXML(obj);
    }

    private static void setClassAliasMap(Map map, XStream xStream) {
        Set set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            Class clazz = (Class) map.get(key);
            xStream.alias(key, clazz);
        }
    }


}
