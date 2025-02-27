package com.java.tasksFromCodewars;

public class PositionAverage {
    public static void main(String[] args) {
        System.out.println(posAverage("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096"));
        System.out.println(posAverage("4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444"));
    }

    public static double posAverage(String s) {
        String[] split = s.split(", ");
        int count = 0;
        int total = 0;
        for (int i = 0; i < split.length; i++) {
            String substring = split[i];
            for (int j = i + 1; j < split.length; j++) {
                System.out.println("compare: \n" + substring + " " + i + "\n" + split[j] + " " + j);
                for(int k = 0;k<substring.length();k++){
                    if(split[j].charAt(k)==substring.charAt(k)){
                        count++;
                    }
                }
                total += substring.length();
                System.out.println("count: " + count);
            }
        }
        return (double)count/total * 100;
    }
}
