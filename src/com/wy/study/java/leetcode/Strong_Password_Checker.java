package com.wy.study.java.leetcode;

/**
 * Created by wy_ms on 2017/05/31.
 */
public class Strong_Password_Checker {

    /**
     * 6~20字符
     * 最少包含一个小写字符、大写字符、数字
     * 不能出现三个连续重复字符
     * @param s
     * @return 返回最小调整数
     */

    public static int strongPasswordChecker(String s) {

        /** check at least one lowercase letter, at least one uppercase letter, and at least one digit */
        /** check if at least has three repeating characters */
        boolean low = false, upp = false, digit = false;
        int three = 0;
        for (int i=0;i<s.length();) {
            char c = s.charAt(i);
            low = (!low && c >= 'a' && c <= 'z') || low;
            upp = (!upp && c>= 'A' && c <= 'Z') || upp;
            digit = (!digit && c >= '0' && c <= '9') || digit;
            int repeat = 1;
            while (++i<s.length() && c == s.charAt(i)) repeat++;
            three = repeat>=3?three+repeat/3:three;
        }

        int second = 0;
        second = !low?second+1:second;
        second = !upp?second+1:second;
        second = !digit?second+1:second;

        if (s.length()<6) {
            /** def length */
            int def = 6 - s.length();
            int total = def>second?def:second;
            return total>three?total:three;
        } else if (s.length()>20) {
            int def = s.length()-20;
            return def + three;
        } else {
            return three>=second? three:second;
        }

    }


    public static void main(String[] args) {
        int res = strongPasswordChecker("ABCDEABCDEAAADEBBAAA1");
        System.out.println(res);
    }
}
