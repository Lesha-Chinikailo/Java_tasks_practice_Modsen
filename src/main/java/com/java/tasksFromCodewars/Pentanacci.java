package com.java.tasksFromCodewars;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pentanacci {
    public static void main(String[] args) {
        System.out.println(countOddPentaFib(45));
    }
    public static long countOddPentaFib(long n) {
        List<Long> number = new ArrayList<>();
        Set<Long> odds = new HashSet<>();
        if(n >= 0) number.add(0L);
        if(n >= 1) {
            number.add(1L);
            odds.add(number.get(1));
        }
        if(n >= 2) {
            number.add(1L);
            odds.add(number.get(2));
        }
        if(n >= 3) number.add(2L);
        if(n >= 4) number.add(4L);

        for (int i = 5; i <= n; i++) {
            long sumOfLastFiveElement = number.get(i - 1) + number.get(i - 2) + number.get(i - 3) + number.get(i - 4) + number.get(i - 5);
            number.add(sumOfLastFiveElement);

            if(sumOfLastFiveElement % 2 != 0) {
                odds.add(sumOfLastFiveElement);
            }
        }
        return odds.size();
    }
}
