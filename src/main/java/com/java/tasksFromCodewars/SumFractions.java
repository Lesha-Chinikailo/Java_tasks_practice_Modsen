package com.java.tasksFromCodewars;

import java.util.ArrayList;
import java.util.Arrays;

public class SumFractions {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2}, {2, 9}, {3, 18}, {4, 24}, {6, 48}};
        System.out.println(sumFracts(a));
    }

    public static String sumFracts(int[][] l) {
        if (l.length == 0 || l[0].length == 0)
            return null;
        for (int i = 0; i < l.length; i++) {
            if (l[i][1] % l[i][0] == 0 && l[i][0] != 1) {
                int divide = (int) gcd(l[i][1], l[i][0]);
                l[i][1] = l[i][1] / divide;
                l[i][0] = l[i][0] / divide;
            }
        }
        long[][] result = new long[l.length][l[0].length];
        long resultLcm = l[0][1];
        for (int i = 1; i < l.length; i++) {
            resultLcm = lcm(resultLcm, l[i][1]);
        }
        for (int i = 0; i < l.length; i++) {
            long diff = resultLcm / l[i][1];
            result[i][1] = diff * l[i][1];
            result[i][0] = diff * l[i][0];
        }

        long sum = Arrays.stream(result).mapToLong(i -> i[0]).sum();
        long denominator = result[0][1];
        long divide = gcd(sum, denominator);
        sum = sum / divide;
        denominator = denominator / divide;
        if (denominator == 1) {
            return String.valueOf(sum);
        } else {
            return "[%d, %d]".formatted(sum, denominator);
        }
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
