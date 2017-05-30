package com.wy.study.java.leetcode;

import java.util.Arrays;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class Longest_Palindromic_Substring {

    public static String longestPalindrome(String s) {
        /** 效率问题，耗时太长 */
        /*int start=0,end=1,ln=1;
        for (int i = 0; i < s.length(); i++) {
            if (s.length()-i<=ln) {
                break;
            }
            long s1 = System.nanoTime();
            char c = s.charAt(i);
            long s2 = System.nanoTime();
            int index = s.length()-1;
            index = s.lastIndexOf((int)c,index);
            long s3 = System.nanoTime();
            while (index!=i) {
                long s4 = System.nanoTime();
                if (isPalindrome(s,i,index)) {
                    long s5 = System.nanoTime();
                    int temln = index-i+1;
                    if (temln>ln) {
                        ln = temln;
                        start = i;
                        end = index+1;
                    }
                    long s6 = System.nanoTime();
                    System.out.println(s2-s1);
                    System.out.println(s3-s2);
                    System.out.println(s4-s3);
                    System.out.println(s5-s4);
                    System.out.println(s6-s5);
                    break;
                }
                index = s.lastIndexOf((int)c,index-1);
            }

        }
        return s.substring(start,end);*/

        /** 比之前还要慢 */
        /*String tem = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            if (s.length()-i<=tem.length()) {
                break;
            }
            char c = s.charAt(i);
            int index = s.length()-1;
            index = s.lastIndexOf((int)c,index);
            while (index!=i) {
                String palindrome = s.substring(i, index);
                StringBuilder builder = new StringBuilder(palindrome);
                if (palindrome.equals(builder.reverse().toString())) {
                    tem = palindrome;
                    break;
                }
                index = s.lastIndexOf((int)c,index-1);
            }

        }
        return tem;*/

        /** 前两种思路是一样的，都是顺位匹配当前字符的其他位置，然后判断这一段是否为回文 */
        /** 换种思维方式，每个点都是回文中点，向两边扩散匹配 */
        if (null==s||s.length()==0) {
            throw new IllegalArgumentException("invalid string");
        }
        int start = 0, ln = 1;
        for (int i = 0; i < s.length();) {
            if ((s.length()-i)<=ln/2) {
                break;
            }
            int k = i,j=i;
            /** 重复字符为回文，只需接着判断回文上下文是否也是回文 */
            while (k<s.length()-1&&s.charAt(k)==s.charAt(k+1)) k++;
            i=k+1;
            while (j>0&&k<s.length()-1&&s.charAt(j-1)==s.charAt(k+1)) {
                j--;
                k++;
            }
            if ((k-j+1)>ln) {
                start=j;
                ln = k-j+1;
            }
        }
        return s.substring(start,start+ln);
    }

    /** 这种回文判断太耗时 */
    public static boolean isPalindrome(String s, int from, int end) {
        for (int i = from, j=end; i<=j ; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
        }
        return  true;
    }

    static boolean isPalindrome1(String s, int from, int end) {

        s.substring(from,end);


        return false;
    }

    public static void main(String[] args) {
        long st1 = System.currentTimeMillis();
        long st = System.nanoTime();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String s = "cbbd";
//        String s ="abcba";
//        String s = "babad";
//        String s = "abadd";
        String res = longestPalindrome(s);
//        boolean isok = isPalindrome(s,0,s.length()-1);
//        System.out.println(isok);
        long en = System.nanoTime();
        long en1 = System.currentTimeMillis();
        System.out.println(res.length());
        System.out.println("时间："+(en-st));
        System.out.println(st+"==="+en);
        System.out.println(en1-st1);
        System.out.println(st1+"==="+en1);
    }



    private int lo, maxLen;

    /** 这种最强大*/
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

}
