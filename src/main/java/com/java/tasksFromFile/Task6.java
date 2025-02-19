package com.java.tasksFromFile;

import static java.lang.Math.max;

public class Task6 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {1};
//        int[] nums = {5,4,-1,7,8};

        System.out.println("sum: " + maximumSubarray(nums));
    }

    private static int maximumSubarray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            currentSum = max(currentSum + nums[i], nums[i]);
            maxSum = max(maxSum, currentSum);
        }

        return maxSum;
    }
}
