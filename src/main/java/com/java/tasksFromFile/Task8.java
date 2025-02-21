package com.java.tasksFromFile;

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        String brackets = "[{()(){}}]";
        System.out.println(validParentheses(brackets));
    }

    private static boolean validParentheses(String brackets) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketsMap = Map.of(
                '{', '}',
                '(', ')',
                '[', ']'
        );
        for (int i = 0; i < brackets.length(); i++) {
            if(bracketsMap.containsKey(brackets.charAt(i))) {
                stack.push(brackets.charAt(i));
            }
            else if(bracketsMap.containsValue(brackets.charAt(i))) {
                if(stack.isEmpty())
                    return false;

                Character openBracket = stack.peek();
                if(bracketsMap.get(openBracket) != brackets.charAt(i)) {
                    return false;
                }
                stack.pop();
            }
            else{
                System.out.println("There is another character in the string");
            }
        }
        return stack.isEmpty();
    }
}
