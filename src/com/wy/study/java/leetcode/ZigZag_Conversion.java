package com.wy.study.java.leetcode;

/**
 * Created by wy_ms on 2017/05/30.
 */
public class ZigZag_Conversion {

    public static String convert(String s, int numRows) {
        if (null==s||s.length()==0||numRows==1) {
            return s;
        }
        char[] c = new char[s.length()];
        int start = 0;
        for (int i = 0; i < numRows; i++) {
            start = fill(c,start,i,numRows,s);
        }
        return new String(c);
    }

    static int fill(char[] c, int start, int i, int numRows, String s) {

        boolean isheadOrTail = i==0 || i==numRows-1;
        boolean down = true;
        int index = i;
        int upstep = 2*(numRows - index - 1);
        int step = 2*(numRows - 1);
        while (index<s.length()) {
            c[start++]=s.charAt(index);
            index = isheadOrTail?index+step:down?index+upstep:index+step-upstep;
            down = !down;
        }
        return start;
    }

    public static String convert1(String s, int numRows) {
        if (null==s||s.length()==0||numRows==1) {
            return s;
        }
        char[] c = new char[s.length()];
        boolean isheadOrTail = true;
        boolean down = true;
        int row = 0;
        int index = 0;
        int upstep = 0;
        int step = 2*(numRows - 1);
        int start = 0;
        while (row<numRows&&index<s.length()) {
            c[start++]=s.charAt(index);
            index = isheadOrTail?index+step:down?index+upstep:index+step-upstep;
            down = !down;
            if (index>=s.length()) {
                row++;
                isheadOrTail = row==0 || row==numRows-1;
                down = true;
                index = row;
                upstep = 2*(numRows - index - 1);
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String input = "";
        int numRow =0;
//        input = "PAYPALISHIRING";
//        numRow = 4;
        input = "A";
        numRow = 2;
//        input = "ABCDE";
//        numRow = 2;

        String s = convert1(input,numRow);
        System.out.println(s);
        String except = "";
//        except = "PAHNAPLSIIGYIR";
        except = "A";
//        except = "ACEBD";
//        except = "PINALSIGYAHRPI";
        assert s.equals(except);
    }

}
