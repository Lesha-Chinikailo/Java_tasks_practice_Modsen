package com.java.tasksFromCodewars;

import java.util.*;

public class Mixing {

    public static void main(String[] args) {
        String s1 = "Are they here";
        String s2 = "yes, they are here";
        System.out.println(mix(s1, s2));
    }

    public static String mix(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (isLowerCase(s1.charAt(i))) {
                map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (isLowerCase(s2.charAt(i))) {
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }
        }

        List<String> results = new ArrayList<>();
//        Set<Character> characters = map1.keySet();

        Set<Character> allChars = new HashSet<>(map1.keySet());
        allChars.addAll(map2.keySet());

        for (Character key : allChars) {
//            if (key == ' ') {
//                continue;
//            }
            int countChar1 = map1.getOrDefault(key, 0);
            int countChar2 = map2.getOrDefault(key, 0);
            int countMax = Math.max(countChar1, countChar2);
            if (countChar1 > 1 || countChar2 > 1) {
                if (countChar1 > countChar2) {
                    results.add("1:" + String.valueOf(key).repeat(countChar1));
                } else if (countChar2 > countChar1) {
                    results.add("2:" + String.valueOf(key).repeat(countChar2));
                } else {
                    results.add("=:" + String.valueOf(key).repeat(countChar1));
                }
            }
            results.sort((a, b) -> {
                int lenDiff = b.length() - a.length();
                if (lenDiff == 0) {
                    return a.compareTo(b);
                }
                return lenDiff;
            });
        }
        return String.join("/", results);

    }

    static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}