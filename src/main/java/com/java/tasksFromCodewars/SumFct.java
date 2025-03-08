package com.java.tasksFromCodewars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SumFct {
    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(5)));
    }
    public static BigInteger perimeter(BigInteger n) {
        return sumFibonacci(n).multiply(BigInteger.valueOf(4));
    }
    private static BigInteger sumFibonacci(BigInteger n) {
        List<BigInteger> fibonacci = new ArrayList<>();
        fibonacci.add(BigInteger.valueOf(1));
        fibonacci.add(BigInteger.valueOf(1));
        for (int i = 2; i <= n.longValue(); i++) {
            fibonacci.add(fibonacci.get(i - 1).add(fibonacci.get(i -2)));
        }
        return fibonacci.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }
}
