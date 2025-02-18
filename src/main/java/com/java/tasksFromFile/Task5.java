package com.java.tasksFromFile;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int target = 9;
        System.out.println(searchInsertPosition(arr, target));
    }

    private static int searchInsertPosition(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
            if(i == arr.length - 1){
                return arr.length;
            }
        }
        return -1;
    }
}
