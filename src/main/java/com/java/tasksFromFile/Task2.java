package com.java.tasksFromFile;

import java.util.Hashtable;

public class Task2 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13 ,14, 15, 3};
        Integer target = 5;
        long start = System.currentTimeMillis();

        twoSum(arr, target);

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
    }

    public static void twoSum(Integer[] arr, Integer target){
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            Integer x = arr[i];
            Integer y = target - x;
            if(map.containsKey(y)){
                System.out.println("[%d, %d]".formatted(map.get(y), i));
                return;
            }
            map.put(x, i);
        }
    }

    public static void twoSumNot(Integer[] arr, Integer target) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++){
                if (i != j && arr[i] < target && arr[j] < target) {
                    if(arr[i] + arr[j] == target){
                        System.out.println("[%d, %d]".formatted(i, j));
                        return;
                    }
                }
            }
        }
    }
}
