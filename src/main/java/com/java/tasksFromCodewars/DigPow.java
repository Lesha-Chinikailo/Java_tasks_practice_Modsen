package com.java.tasksFromCodewars;

public class DigPow {
    public static void main(String[] args) {
        System.out.println(digPow(46288, 3));
    }

    public static long digPow(int n, int p) {
        double sumOfPowers = 0;
        String n_string = Integer.toString(n);
        for (int i = 0; i < n_string.length(); i++) {
            double number = Integer.parseInt(String.valueOf(n_string.charAt(i)));
            number = Math.pow(number, p++);
            sumOfPowers += number;
        }
        double result = sumOfPowers / n;
        if(result - Math.floor(result) == 0){
            return (long)result;
        }
        // your code
        return -1;
    }
}
