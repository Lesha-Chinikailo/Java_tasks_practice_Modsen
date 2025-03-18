package com.java.tasksFromCodewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SqProd2Sum {
    public static void main(String[] args) {
        prod2Sum(1, 2, 1, 3).forEach(item -> Arrays.stream(item).forEach(System.out::println));

        prod2Sum(2, 3, 4, 5).forEach(item -> Arrays.stream(item).forEach(System.out::println));
        prod2Sum(1, 1, 3, 5).forEach(item -> Arrays.stream(item).forEach(System.out::println));
    }

    public static List<long[]> prod2Sum(long a, long b, long c, long d) {
        long[] options = new long[]{
                Math.abs(a * c - b * d),
                Math.abs(a * d + b * c),
                Math.abs(a * c + b * d),
                Math.abs(a * d - b * c)
        };

        Arrays.sort(options);

        List<long[]> result = new ArrayList<>();

        result.add(new long[]{options[0], options[3]});
        result.add(new long[]{options[1], options[2]});

        if (Arrays.equals(result.get(0), result.get(1))) {
            result.remove(1);
        }

        // Ensure each pair is sorted and then sort the list of pairs
        result.forEach(Arrays::sort);
        result.sort((pair1, pair2) -> {
            if (pair1[0] != pair2[0]) {
                return Long.compare(pair1[0], pair2[0]);
            }
            return Long.compare(pair1[1], pair2[1]);
        });

        return result;
    }
}
