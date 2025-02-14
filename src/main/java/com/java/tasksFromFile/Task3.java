package com.java.tasksFromFile;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 4, 5, 5, 3, 7};
        int ans = 0;
        for (int v : arr) {
            ans ^= v;
        }
        System.out.println(ans);

    }
}
