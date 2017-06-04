package com.wy.study.java.leetcode;

/**
 * Created by wy_ms on 2017/05/30.
 */
public class Reverse_Integer {


    public static int reverse(int x) {

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        char[] c = String.valueOf(x).toCharArray();

        for (int i=('-'==c[0]?1:0), j= c.length-1;i<=j;i++,j--) {
            char ch = c[i];
            c[i] = c[j];
            c[j] = ch;
        }
        long result = Long.valueOf(String.valueOf(c));
        if (result>MAX||result<MIN) {
            return 0;
        }
        return (int) result;
    }

    public static int reverse1(int x) {

        int result = x%10;
        while ((x/=10)!=0) {
            int tem = x%10 + result*10;
            if (result!=tem/10)
                return 0;
            result = tem;
        }
        return result;
    }

    public static int reverse2(int x) {

        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }


    public static void main(String[] args) {
        /*System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        int x = 0;
        int except = 0;
//        x = 123;
//        except = 321;
        x = -123;
        except = -321;
        int result = reverse(x);
        System.out.println(result);
        assert result==except;*/
//        int result = reverse2(Integer.MAX_VALUE);
//        System.out.println(result);
    }

}
