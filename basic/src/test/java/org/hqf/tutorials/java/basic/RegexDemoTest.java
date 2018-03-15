package org.hqf.tutorials.java.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegexDemoTest {

    @Test
    public void regexValid() {

        String value = "AAAQ333s333s333";

        RegexDemo.RegexValid(value);
    }
}