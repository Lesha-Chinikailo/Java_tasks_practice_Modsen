package com.java.tasksFromFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long start = System.currentTimeMillis();
        System.out.println(containsDuplicate(arr));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            set.add(j);
        }
        return set.size() < arr.length;
    }
}
