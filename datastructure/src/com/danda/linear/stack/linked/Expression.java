package com.danda.linear.stack.linked;

/**
 * {@code @description:}
 */
public class Expression {
    public static void main(String[] args) {
        // 中缀表达式：3*(17-15)+18/6
        // 后缀表达式：
        String[] notation = new String[]{"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println(result);
    }
    
    static int calculate(String[] str) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        Integer pop1;
        Integer pop2;
        int r;
        
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "+":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    
                    r = pop2 + pop1;
                    stack.push(r);
                    break;
                case "-":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    
                    r = pop2 - pop1;
                    stack.push(r);
                    break;
                case "*":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    
                    r = pop2 * pop1;
                    stack.push(r);
                    break;
                case "/":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    
                    r = pop2 / pop1;
                    stack.push(r);
                    break;
                default:
                    stack.push(Integer.valueOf(str[i]));
            }
        }
        Integer result = stack.pop();
        return result;
    }
}