package com.java.tasksFromCodewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSumDig {
    public static void main(String[] args) {
        System.out.println(powerSumDigTerm(2));
    }

    private static final int MAX_POWER = 50;
    private static final long MAX_NUMBER_TO_CHECK = 500;

    public static long powerSumDigTerm(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        List<Long> resultList = new ArrayList<>();

        for (int i = 2; i < MAX_NUMBER_TO_CHECK; i++) {
            for (int j = 2; j < MAX_POWER; j++) {
                long product = (long) Math.pow(i, j);
                if (sumOfDigits(product) == i) {
                    resultList.add(product);
                }
            }
        }
        Collections.sort(resultList);

        return resultList.get(n - 1);
    }

    private static long sumOfDigits(long number) {
        long numberOfDigits = 0;
        while (number > 0) {
            numberOfDigits = numberOfDigits + number % 10;
            number = number / 10;
        }
        return numberOfDigits;
    }
}




//    private static final Map<Integer, Integer> memo = new HashMap<>();
//    public static long powerSumDigTerm(int n) {
//        long count = 0;
//        int number = 10;
//        while(true){
//            long n1 = sumDigits(number);
//            if(Math.pow(n1, String.valueOf(number).length()) == number){
//                count++;
//                if(count == n){
//                    return number;
//                }
//            }
//        }
//    }
//    private static int sumDigits(int num) {
//        if (memo.containsKey(num)) {
//            return memo.get(num);
//        }
//        String str = String.valueOf(num);
//        int sum = 0;
//        while (num != 0) {
//            sum += num % 10;
//            num /= 10;
//        }
//        memo.put(num, sum);
//        return sum;
//    }
//}
