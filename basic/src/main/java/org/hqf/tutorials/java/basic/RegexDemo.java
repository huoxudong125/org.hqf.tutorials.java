package org.hqf.tutorials.java.basic;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void RegexValid(String str){

        String amcRulRegexExpression = "^AAAQ[a-zA-Z0-9]{11}$";
        Pattern pattern = Pattern.compile(amcRulRegexExpression);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("matcher group= " + matcher.group(0));
        }
        else
        {
            System.out.println("not found");
        }
    }
}
