package com.java.tasksFromCodewars;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stat {
    public static void main(String[] args) {
        System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34"));
    }

    public static String stat(String strg) {
        // your code
        String[] split = strg.split(", ");
        List<Integer> dateTimesInSeconds = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH|mm|ss");
        for (String s : split) {
            String[] timeComponents = s.split("\\|");
            String formattedTime = String.format("%02d|%02d|%02d",
                    Integer.parseInt(timeComponents[0]),
                    Integer.parseInt(timeComponents[1]),
                    Integer.parseInt(timeComponents[2]));
            dateTimesInSeconds.add(LocalTime.parse(formattedTime, formatter).toSecondOfDay());
        }
        Integer max = Collections.max(dateTimesInSeconds);
        Integer min = Collections.min(dateTimesInSeconds);
        int range = max - min;
        int sizeOfList = dateTimesInSeconds.size();
        int average = dateTimesInSeconds.stream().mapToInt(i -> i).sum() / sizeOfList;
        Collections.sort(dateTimesInSeconds);
        Integer median;
        if (sizeOfList % 2 != 0) {
            median = dateTimesInSeconds.get(sizeOfList / 2);
        } else {
            median = (dateTimesInSeconds.get(sizeOfList / 2) +
                    dateTimesInSeconds.get(sizeOfList / 2 - 1))
                    / 2;
        }
        LocalTime rangeTime = LocalTime.ofSecondOfDay(range);
        LocalTime averageTime = LocalTime.ofSecondOfDay(average);
        LocalTime medianTime = LocalTime.ofSecondOfDay(median);
        StringBuilder sb = new StringBuilder();
        sb.append("Range: ");
        sb.append(rangeTime.format(formatter));
        sb.append(" Average: ");
        sb.append(averageTime.format(formatter));
        sb.append(" Median: ");
        sb.append(medianTime.format(formatter));

        return sb.toString();
    }
}
