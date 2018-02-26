package org.hqf.tutorials.java.basic;

public class DoubleDemo {

    public static void main(String[] args) {
        DoubleValues doubleValues=new DoubleValues();

        String doubleStr = "1";
        double doubleValue1 = Double.parseDouble(doubleStr);
        Double DValue1 = Double.parseDouble(doubleStr);
        doubleValues.var1=doubleValue1;


        System.out.println("doubleValue = " + doubleValue1);

        doubleStr = ".1";
        double doubleValue2 = Double.parseDouble(doubleStr);
        Double DValue2 = Double.parseDouble(doubleStr);
        doubleValues.var2=doubleValue2;

        System.out.println("doubleValue = " + doubleValue2);

        System.out.println();

        System.out.println("doubleValue2 = " + add(doubleValue1, doubleValue2));
        System.out.println("doubleValue1 = " + doubleValue1);

        System.out.println();
        System.out.println("doubleValue2 = " + add(DValue1, DValue2));
        System.out.println("DValue1 = " + DValue1);


        System.out.println();
        System.out.println("doubleValue2 = " + add(doubleValues.var1, doubleValues.var2));
        System.out.println("doubleValues.var1 = " + doubleValues.var1);


        System.out.println();
        addForObject(doubleValues);
        System.out.println("doubleValue2 = " + add(doubleValues.var1, doubleValues.var2));
        System.out.println("doubleValues.var1 = " + doubleValues.var1);


//        doubleStr = "";
//        double doubleValue = Double.parseDouble(doubleStr);
//
//        System.out.println("doubleValue = " + doubleValue);
    }


    private static Double add(Double originValue, Double addValue) {
        return originValue += addValue;
    }


    private static double add(double originValue, double addValue) {
        return originValue += addValue;
    }



    private static  DoubleValues addForObject(DoubleValues doubleValues){

        doubleValues.var1+=100;
        doubleValues.var2+=200;

        return doubleValues;
    }


}

class DoubleValues{
    public double var1;
    public double var2;
}
