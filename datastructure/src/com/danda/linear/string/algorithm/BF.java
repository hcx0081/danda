package com.danda.linear.string.algorithm;

/**
 * {@code @description:}
 */
public class BF {
    public static void main(String[] args) {
        System.out.println(bf("aaaab", "ab", 0));
    }
    
    /**
     * BF算法
     *
     * @param s   正文串
     * @param t   模式串
     * @param pos 正文串开始比较的索引位置
     * @return
     */
    public static int bf(String s, String t, int pos) {
        int sIndex = pos;
        int tIndex = 0;
        while (sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                // 索引位置 - 移动距离 + 1
                // sIndex = sIndex - tIndex + 1;
                sIndex = pos++ + 1;
                tIndex = 0;
            }
        }
        // 返回匹配串在正文串中的索引位置
        return sIndex - t.length();
    }
}