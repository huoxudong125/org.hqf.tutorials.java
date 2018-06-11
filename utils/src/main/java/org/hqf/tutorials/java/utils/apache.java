package org.hqf.tutorials.java.utils;

import org.apache.commons.lang.StringUtils;
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



        String numStr="";
        BigDecimal bigDecimal=ConvertStrToBigDecimal(numStr);
        System.out.println("bigDecimal = " + bigDecimal);
        numStr="1.6215876E7";
        bigDecimal=ConvertStrToBigDecimal(numStr);
        System.out.println("bigDecimal = " + bigDecimal);

        numStr="123456789123.123456";
        bigDecimal=ConvertStrToBigDecimal(numStr);
        System.out.println("bigDecimal = " + bigDecimal);


        numStr="123456789123.123456d";
        bigDecimal=ConvertStrToBigDecimal(numStr);
        System.out.println("bigDecimal = " + bigDecimal);
    }

    private static void IsNumberStr(String numberStr) {
        boolean isNumber = NumberUtils.isNumber(numberStr);
        System.out.println("numberStr" + numberStr + ",isNumber = " + isNumber);
    }


    private static BigDecimal ConvertStrToBigDecimal(String decimalStr) {
        BigDecimal result = null;

        if (StringUtils.isNotBlank(decimalStr)) {
            String trimmedDecimalStr = decimalStr.trim();
            if (NumberUtils.isNumber(trimmedDecimalStr)) {
                result = new BigDecimal(trimmedDecimalStr);
            } else {
               String msg= String.format("ConvertStrToBigDecimal 字符串转BigDecimal失败，当前参数为【%s】", decimalStr);
                System.out.println("msg = " + msg);
            }
        } else {
           String msg=String.format("ConvertStrToBigDecimal 字符串转BigDecimal失败，当前参数为【%s】", decimalStr);
            System.out.println("msg = " + msg);
        }

        return result;
    }

}
