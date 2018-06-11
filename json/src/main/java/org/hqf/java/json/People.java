package org.hqf.java.json;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/06/11
 */
@Setter
@Getter
public class People {

    private Date bornDate;

    private String name;

    private int age;

    private TitleTypeEnum titleType;
}


