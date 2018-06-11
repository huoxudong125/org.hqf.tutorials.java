package org.hqf.java.json;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/06/11
 */
public enum TitleTypeEnum {

    Employee((byte) 1, "Employee"),
    Manager((byte) 2, "Manager");

    TitleTypeEnum(byte code, String titleName) {
        this.code = code;
        this.name = titleName;

    }

    private byte code;
    private String name;


    private byte getCode(){
        return code;
    }

    private String getName(){
        return name;
    }


}
