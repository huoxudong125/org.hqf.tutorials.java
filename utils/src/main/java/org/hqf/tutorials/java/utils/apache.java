package org.hqf.tutorials.java.utils;

import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;

/**
 * describe:
 *
 * @author huoquanfu
 * @date 2018/04/27
 */
public class apache {

    public static void main(String[] args) {

        String numberStr = "123456.123";
        IsNumberStr(numberStr);

        String numberStrWithSpace=" 12346.10 ";
        IsNumberStr(numberStrWithSpace);
        IsNumberStr(numberStrWithSpace.trim());
        BigDecimal doubleNum=new BigDecimal(numberStrWithSpace.trim());
        System.out.println("doubleNum = " + doubleNum);

//        String numberStrWithE="9.993984E8";
        String numberStrWithE="1.6215876E7";
        IsNumberStr(numberStrWithE);
        IsNumberStr(numberStrWithE.trim());
        BigDecimal doubleNumE=new BigDecimal(numberStrWithE.trim());
        System.out.println("doubleNumE = " + doubleNumE);
        System.out.println("doubleNumE = " + doubleNumE.toPlainString());
    }

    private static void IsNumberStr(String numberStr) {
        boolean isNumber = NumberUtils.isNumber(numberStr);
        System.out.println("numberStr" + numberStr + ",isNumber = " + isNumber);
    }

}
