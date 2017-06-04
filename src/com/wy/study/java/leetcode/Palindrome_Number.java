package com.wy.study.java.leetcode;

/**
 * Created by wy_ms on 2017/05/30.
 */
public class Palindrome_Number {

    public static boolean isPalindrome(int x) {
        if (x<0||(x%10==0&&x>0)) {
            return false;
        }
        int result = x%10;
        while (result<x) {
            x/=10;
            if (result==x) {
                return true;
            }
            result = x%10 + result*10;
        }
        return result==x;
    }

    public static boolean isPalindrome2(int x) {
        if (x<0||(x>0&&x%10==0)) return false;
        char[] chars = String.valueOf(x).toCharArray();
        int mid = (chars.length-1)/2;
        int mid2 = chars.length/2;
        for (int i=mid,j=mid2;mid>=0;i--,j++)
            if (chars[i]!=chars[j]) return false;
        return true;
    }

    public static boolean isPalindrome3(int x) {
        if (x<0) return false;
        int length = 1;
        int tem = x;
        while ((tem/=10)!=0) length++;
        length = length/2;
        int result = 0;
        while(length!=0) {
            result = x%10 + result*10;
            if (result==0)  return false;
            x /= 10;
            length --;
        }
        return x==result||x==result*10+x%10;
    }

    public static boolean isPalindrome4(int x) {
        if (x<0) return false;
        int tem = x;
        int res = tem%10;
//        while ((tem/=10)!=0) res=res*10+tem%10;
        for (res=tem%10; tem/10!=0 ; res=res*10+tem%10) {}
        return res==x;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome4(11));
    }
}
