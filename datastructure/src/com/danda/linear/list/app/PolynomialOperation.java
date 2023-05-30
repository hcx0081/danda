package com.danda.linear.list.app;

import com.danda.linear.list.sequence.SequenceList;

import java.util.Arrays;

/**
 * {@code @Description:} 一元多项式运算：实现两个多项式加、减、乘运算
 * P_n(x) = p_0 + p_1x + p_2x + ... + p_nx^n
 * 线性表：P=(p_0, p_1, p_2...p_n)存储每一项的系数，每一项的指数隐含在系数p_i的序号中
 * 换句话说：顺序表存储每一项的系数，下标表示每一项的指数
 */
public class PolynomialOperation {
    /*
     * 假设：
     * P_a(x) = 10 + 5x - 4x^2 + 3x^3 + 2x^4
     * P_b(x) = -3 + 8x + 4x^2 - 5x^4 + 7x^5 - 2x^6
     *  */
    SequenceList<Integer> l1 = new SequenceList<>(5);
    SequenceList<Integer> l2 = new SequenceList<>(7);
    
    public PolynomialOperation() {
        this.l1.add(10);
        this.l1.add(5);
        this.l1.add(-4);
        this.l1.add(3);
        this.l1.add(2);
        
        this.l2.add(-3);
        this.l2.add(8);
        this.l2.add(4);
        this.l2.add(0);
        this.l2.add(-5);
        this.l2.add(7);
        this.l2.add(-2);
    }
    
    public static void main(String[] args) {
        PolynomialOperation polynomialOperation = new PolynomialOperation();
        SequenceList<Integer> list = polynomialOperation.add();
        System.out.println(Arrays.toString(list.eleArr));
    }
    
    SequenceList<Integer> add() {
        SequenceList<Integer> list = new SequenceList<>(7);
        // j表示指数
        for (int j = 0; j < l2.length(); j++) {
            // i表示指数
            for (int i = 0; i < l1.length(); i++) {
                // 如果指数相同
                if (i == j) {
                    // 系数相加
                    Integer coe = l1.get(j) + l2.get(j);
                    list.add(i, coe);
                    break;
                }
            }
            // 如果j大于l1的最大指数
            if (j > l1.length() - 1) {
                list.add(j, l2.get(j));
            }
        }
        return list;
    }
}