package org.hqf.java.doc;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hqf
 */

public enum YnEnum {

    /**
     * 否
     */
    NO(Byte.parseByte("0"), "否"),
    /**
     * 是
     */
    YES(Byte.parseByte("1"), "是");


    /**
     * 定义一个 EnumMap 对象，
     * eg.映射表主键是日期枚举类型，值是颜色枚举类型
     */
    public static final Map<String, Byte> EnumMap = new HashMap<String, Byte>();

    static {
        for (YnEnum e : EnumSet.allOf(YnEnum.class)) {
            EnumMap.put(e.getName(), e.getCode());
        }
    }

    private final String name;
    private final Byte code;

    YnEnum(Byte code, String name) {
        this.name = name;
        this.code = code;
    }

    public Byte getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
