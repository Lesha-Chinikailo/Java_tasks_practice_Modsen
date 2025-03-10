package com.java.tasksFromCodewars;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
    public static void main(String[] args) {
        System.out.println(presses("HOW R U"));
    }
    public static int presses(String phrase) {
        Map<Integer, String> map = initMap();
        int countPress = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if(Character.isDigit(phrase.charAt(i))) {
                Integer key = Integer.parseInt(String.valueOf(phrase.charAt(i)));
                countPress += map.get(key).length() + 1;
            }
            if(Character.isLetter(phrase.charAt(i))) {
                char letter = Character.toUpperCase(phrase.charAt(i));
                String value = map.values().stream()
                        .filter(v -> v.contains(Character.toString(letter)))
                        .findFirst().get();
                int indexLetter = value.indexOf(letter);
                countPress += indexLetter + 1;
            }
            if(Character.isWhitespace(phrase.charAt(i))) {
                countPress++;
            }
            if(phrase.charAt(i) == '*' || phrase.charAt(i) == '#') {
                countPress++;
            }
        }
        return countPress;
    }

    private static Map<Integer, String> initMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "");
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");
        map.put(0, " ");
        return map;
    }
}
