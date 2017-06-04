package com.wy.study.java.leetcode;

import java.util.Arrays;

/**
 * Created by wy_ms on 2017/06/04.
 */
public class Trapping_Rain_Water {

    public static int trap(int[] height) {

        int result = 0;
        int[] rain = new int[height.length];
        int rainln = 0;
        boolean pretrand = false;
        for (int i = 1; i < height.length;) {

            int k = i-1;
            while (++i<height.length&&height[i]==height[i-1]){}
            if (height[i-1]>height[k]) {
                pretrand = false;
                if (i==height.length) {
                    rain[rainln++] = i-1;
                    break;
                }
                continue;
            } else if (height[i-1]<height[k]&&!pretrand) {
                rain[rainln++] = k;
                pretrand = true;
            }
        }
        if (rainln<2) {
            return 0;
        }
        for (int i = 1; i < rainln; i++) {
            int
                    sind = rain[i-1],
                    eind = rain[i],
                    s = height[sind],
                    e = height[eind];

            if (e<s) {
                for (int j = i+1; j < rainln ; j++) {
                    int tem = rain[j];
                    int temh = height[tem];
                    if (temh>=s) {
                        eind = tem;
                        i = j;
                        break;
                    } else if (temh>=e) {
                        eind = tem;
                        e = temh;
                        i = j;
                    }
                }
            }
            result += getRain(height,sind,eind);
        }
        return result;
    }

    static int getRain(int[] h, int start, int end) {

        int eh = h[end], sh = h[start];
        if (sh>eh) {
            for (int i = start+1; i < end; i++) {
                int temh = h[i];
                if (temh>=eh) {
                    start = i;
                    sh = temh;
                } else break;
            }
        } else if (sh<eh) {
            for (int i = end-1; i >start; i--) {
                int temh = h[i];
                if (temh>=sh) {
                    end = i;
                    eh = temh;
                } else break;
            }
        }
        int w = end-start-1;
        int l = sh>eh?eh:sh;
        int sum = 0;
        for (int i = start+1; i <end ; i++) {
            sum = h[i] + sum;
        }
        return w*l-sum;
    }


    public static void main(String[] args) {
        int [] h = null;
//        h = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        h = new int[]{2,0,2};
//        h = new int[]{5,4,1,2};
//        h = new int[]{5,5,4,7,8,2,6,9,4,5};
        h = new int[]{3,9,8,1,1,4,1,5,1,4,1,1,2};
        int result = trap2(h);
        System.out.println(result);
    }

    public static int trap2(int[] height) {

        int
                left=0,
                right=height.length-1,
                leftmax=0,
                rightmax=0,
                result = 0;
        while (left<=right) {

            if (leftmax<=rightmax) {
                if (height[left] > leftmax) {
                    leftmax = height[left];
                } else {
                    result += leftmax - height[left];
                }
                left++;
            } else {
                if (height[right]>rightmax) {
                    rightmax = height[right];
                } else {
                    result += rightmax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}
