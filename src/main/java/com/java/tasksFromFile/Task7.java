package com.java.tasksFromFile;

import java.util.ArrayList;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr2 = {0};
        subSets(arr).forEach(a -> {
            System.out.print("[");
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println("]");
        });
    }

    public static List<List<Integer>> subSets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        depthFirstSearch(arr, 0, t, ans);
        return ans;
    }

    private static void depthFirstSearch(int[] arr, int i, List<Integer> current, List<List<Integer>> ans) {
        if (i == arr.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        depthFirstSearch(arr, i + 1, current, ans);
        current.add(arr[i]);
        depthFirstSearch(arr, i + 1, current, ans);
        current.remove(current.size() - 1);
    }
}
