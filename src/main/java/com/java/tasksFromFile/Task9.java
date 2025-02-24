package com.java.tasksFromFile;

import java.util.Stack;

public class Task9 {
    public static void main(String[] args) {
        String input = "()()(())";
        System.out.println(longestValidParentheses(input));
    }

    public static int longestValidParentheses(String brackets) {
        int length = brackets.length();
        int[] f = new int[length + 1];
        int maxLength = 0;
        char closeBracket = ')';
        char openBracket = '(';
        for (int i = 2; i <= length; ++i) {
            if (brackets.charAt(i - 1) == closeBracket) {
                if (brackets.charAt(i - 2) == openBracket) {
                    f[i] = f[i - 2] + 2;
                } else {
                    int j = i - f[i - 1] - 1;
                    if (j > 0 && brackets.charAt(j - 1) == openBracket) {
                        f[i] = f[i - 1] + 2 + f[j - 1];
                    }
                }
                maxLength = Math.max(maxLength, f[i]);
            }
        }
        return maxLength;
    }

    @Deprecated
    private static Integer longestValidParentheses2(String input) {
        Stack<Character> stack = new Stack<>();
        Character openBracket = '(';
        Character closeBracket = ')';
        int countOpenBrackets = 0;
        int countCloseBrackets = 0;
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == openBracket) {
                countOpenBrackets++;
            }
            if(input.charAt(i) == closeBracket) {
                if(countOpenBrackets == 0){
                    currentLength = 0;
                }
//                countCloseBrackets++;
                countOpenBrackets--;
                currentLength += 2;
            }
            if(currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}


/*
* for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == openBracket) {
                stack.push(input.charAt(i));
            }
            else if(input.charAt(i) == closeBracket) {
                if(stack.isEmpty()){
                    currentLength = 0;
                    continue;
                }
//                Character openBracket = stack.peek();
                if(closeBracket != input.charAt(i)) {
                    stack.empty();
                    currentLength = 0;
                    continue;
                }
                stack.pop();
                currentLength += 2;
            }
            else{
                System.out.println("There is another character in the string");
            }

            if(currentLength > maxLength) {
                maxLength = currentLength;
            }


//            if(input.charAt(i) == openBracket) {
//                currentLength++;
//            }
//            if(input.charAt(i) == closeBracket) {
//                if(currentLength > 0){
//
//
//                }
//            }
        }
* */
