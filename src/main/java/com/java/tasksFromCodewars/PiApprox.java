package com.java.tasksFromCodewars;

import java.text.DecimalFormat;

public class PiApprox {
    public static void main(String[] args) {
        System.out.println(iterPi2String(0.1));
    }
    public static String iterPi2String(Double epsilon) {
        long count = 0;
        double pi = Math.PI;
        double result = 0;
        double numerator = 1;
        double denominator = 1;
        while(Math.abs(result * 4 - pi) >= epsilon) {
            if(count % 2 == 0) {
                result += (numerator/denominator);
            }
            else{
                result -= (numerator/denominator);
            }
            count++;
            denominator += 2;
        }
        DecimalFormat df = new DecimalFormat("0.0000000000");

        return String.format("[%d, %s]", count, df.format(4 * result));
    }
}
