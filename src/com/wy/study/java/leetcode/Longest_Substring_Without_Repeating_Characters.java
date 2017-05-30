package com.wy.study.java.leetcode;

/**
 * Created by wy_ms on 2017/05/28.
 */
public class Longest_Substring_Without_Repeating_Characters {

    public static int lengthOfLongestSubstring(String s) {

        int ln = 0;
        String tem = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = tem.indexOf(c);
            if (index>-1) {
                tem = tem.substring(index+1);
            }
            tem += c;
            ln= tem.length()>ln?tem.length():ln;
        }
        return ln;
    }
    public static int lengthOfLongestSubstring1(String s) {

        int ln = 0;
        StringBuilder tem = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int index = tem.indexOf(c+"");
            if (index>-1) {
                tem = new StringBuilder(tem.substring(index+1));
            }
            tem.append(c);
            ln= tem.length()>ln?tem.length():ln;
        }
        return ln;
    }

    public static int lengthOfLongestSubstring2(String s) {

        int ln = 0, temln=0, index=0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tindex = s.indexOf(c,index);
            index = tindex>-1&&tindex!=i?tindex+1:index;
            temln = i-index+1;
            ln = temln>ln?temln:ln;
        }
        return ln;
    }

    public static void main(String[] args) {
        int n = lengthOfLongestSubstring2("bbb");
        System.out.println(n);
    }
}
