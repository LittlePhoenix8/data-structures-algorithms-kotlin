package pramp;

import java.util.Stack;

public class BracketMatch {
    static int bracketMatch(String text) {
        int count = 0;
        int brackets = 0;
        for(char c : text.toCharArray()) {
            if(c == '(') {
                count++;
            } else if(c == ')') {
                count--;
            }
            if(count < 0) {
                count++;
                brackets++;
            }
        }
        return brackets + count;
    }

    static int bracketMatchWithStack(String text) {
        int brackets = 0;
        Stack<Character> stack = new Stack();
        for(char c : text.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    brackets++;
                }
            }
        }
        if(stack.size() == 0) {
            return brackets;
        }
        if(brackets == 0) {
            return stack.size();
        }
        return brackets + stack.size();
    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("(()") + "1");
        System.out.println(bracketMatch("(())") + "0");
        System.out.println(bracketMatch("())(") + "2");

        System.out.println(bracketMatch(")") + "1");
        System.out.println(bracketMatch("(") + "1");
        System.out.println(bracketMatch("(())") + "0");
        System.out.println(bracketMatch("(()") + "1");
        System.out.println(bracketMatch("())(") + "2");
        System.out.println(bracketMatch("))))") + "4");
        System.out.println(bracketMatch(")(") + "2");
    }
}
