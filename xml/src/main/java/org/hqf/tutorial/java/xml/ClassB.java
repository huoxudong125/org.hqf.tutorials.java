package org.hqf.tutorial.java.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author huoquanfu
 * @date 2019/01/16
 */
@XStreamAlias("classBAlias")
public class ClassB {

    @XStreamAlias("classAliasField")
    private String alias;

    private String field;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
