package com.java.tasksFromCodewars;

public class PlayPass {
    public static void main(String[] args) {
        String passphrases = "A aF fZ z";
        int shift = 25;
        System.out.println(playPass(passphrases, shift));
    }
    public static String playPass(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        state_1(sb, n);
        System.out.println("state 1: " + sb.toString());
        state_2(sb);
        System.out.println("state 2: " + sb.toString());
        state_4(sb);
        System.out.println("state 4: " + sb.toString());
        state_5(sb);
        return sb.toString();
    }

    private static void state_1(StringBuilder passphrases, int shift){
        int countLetter = 26;
        for(int i = 0; i < passphrases.length(); i++){
            char charNow = passphrases.charAt(i);
            if(Character.isLetter(charNow)){
                int chatResultInt = charNow + shift;
                int max = 0;
                int min = 0;
                if(Character.isUpperCase(charNow)){
                    max = 90;
                    min = 65;
                }
                else if(Character.isLowerCase(charNow)){
                    max = 122;
                    min = 97;
                }
                int i1 = max - (countLetter - shift) + (min - charNow);
                if(chatResultInt <= max){
                    passphrases.setCharAt(i, (char) chatResultInt);
                }
                else{
                    passphrases.setCharAt(i, (char) (chatResultInt - (countLetter)));
                }
            }
        }
    }

    private static void state_2(StringBuilder passphrases) {
        int numberAddition = 9;
        for (int i = 0; i < passphrases.length(); i++) {
            char charNow = passphrases.charAt(i);
            if(Character.isDigit(charNow)){
                int number = Integer.parseInt(String.valueOf(charNow));
                number = numberAddition - number;
                passphrases.setCharAt(i, Integer.toString(number).charAt(0));
            }
        }
    }

    private static void state_4(StringBuilder passphrases) {
        for(int i = 0; i < passphrases.length(); i++){
            char charNow = passphrases.charAt(i);
            if(Character.isLetter(charNow)){
                if(i % 2 == 0){
                    passphrases.setCharAt(i, Character.toUpperCase(charNow));
                }
                else {
                    passphrases.setCharAt(i, Character.toLowerCase(charNow));
                }
            }
        }
    }


    private static void state_5(StringBuilder passphrases) {
        passphrases.reverse();
    }

}
