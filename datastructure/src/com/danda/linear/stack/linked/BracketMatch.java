package com.danda.linear.stack.linked;

/**
 * {@code @Description:}
 */
public class BracketMatch {
    public static void main(String[] args) {
        String str = "北京)(上海)";
        
        boolean match = isMatch(str);
        System.out.println(match);
    }
    
    static boolean isMatch(String str) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}