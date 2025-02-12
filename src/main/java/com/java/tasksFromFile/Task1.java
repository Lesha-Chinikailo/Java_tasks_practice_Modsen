package com.java.tasksFromFile;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        String numberStr = sc.next();
        System.out.println(isPalindrome(numberStr));
    }

    private static boolean isPalindrome(String numberStr) {
        int length = numberStr.length();
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            if (numberStr.charAt(i) != numberStr.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
