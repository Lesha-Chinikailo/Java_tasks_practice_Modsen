package com.java.tasksFromCodewars;

import java.util.ArrayList;
import java.util.List;

public class MatchSubst {
    public static void main(String[] args) {
        String s1="Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
        System.out.println(change(s1, "Ladder", "1.1"));
    }
    public static String change(String s, String prog, String version) {
        String[] split = s.split("\n");
        List<String> list = new ArrayList<>();
        for (String string : split) {
            if (string.contains("Program title:")) {
                list.add("Program: " + prog);
            }
            if (string.contains("Author:")) {
                list.add("Author: " + "g964");
            }
            if (string.contains("Phone: ")) {
                String replace = string.replace("Phone: ", "");
                if (replace.matches("\\+1-\\d{3}-\\d{3}-\\d{4}")) {
                    list.add("Phone: " + "+1-503-555-0090");
                } else {
                    return "ERROR: VERSION or PHONE";
                }
            }
            if (string.contains("Date: ")) {
                list.add("Date: " + "2019-01-01");
            }
            if (string.contains("Version: ")) {
                String replace = string.replace("Version: ", "");
                if (!checkVersion(replace)) {
                    return "ERROR: VERSION or PHONE";
                }
                if (replace.equals("2.0")) {
                    list.add("Version: " + replace);
                } else {
                    list.add("Version: " + version);
                }
            }

        }

        return String.join(" ", list);
    }

    private static boolean checkVersion(String version) {
        String[] split = version.split("\\.");
        if(split.length == 2){
            for(int i = 0; i < split.length; i++){
                try {
                    Integer.parseInt(split[i]);
                } catch(NumberFormatException e){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }
}
