package com.java.tasksFromCodewars;

public class VolTank {
    public static void main(String[] args) {
        System.out.println(tankVol(5, 7, 3848));
    }
    public static int tankVol(int h, int d, int vt) {
        double r = d / 2.0;
        double theta = Math.acos((r - h) / r);
        double segmentArea = r * r * (theta - Math.sin(2 * theta) / 2);
        double remainingVolume = segmentArea * d;
        return (int) Math.floor((remainingVolume / (Math.PI * r * r * d)) * vt);
    }
}
