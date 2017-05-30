package com.wy.study.java.multithread.finallytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by wy_ms on 2017/05/26.
 */
public class ReturnWaitFinally {

    static void f() {
        try {
            return;
        } finally {
            try {
                System.out.println("开始睡眠10秒钟");
                Thread.sleep(10000);
                System.out.println("睡眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {

        boolean iseven = target%2==0;
        int[] even_less = new int[nums.length];
        int[] even_high = new int[nums.length];
        int[] odd_less = new int[nums.length];
        int[] odd_high = new int[nums.length];
        int[] result = new int[2];
        int half = target/2,
                even_less_ln = 0,
                even_high_ln = 0,
                odd_less_ln = 0,
                odd_high_ln = 0,
                result_ln = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];
            boolean less = p<=half;
            boolean even = p%2==0;

            if (iseven&&p==half) {
                result[result_ln++] = i;
            }
            if (result_ln==2) {
                return result;
            }

            if (even&&less) {
                even_less[even_less_ln++] = i;
            } else if (even&&!less) {
                even_high[even_high_ln++] = i;
            } else if (!even&&less) {
                odd_less[odd_less_ln++] = i;
            } else {
                odd_high[odd_high_ln++] = i;
            }
        }

        if (iseven) {
            result = sum(nums,target,even_less,even_high,even_less_ln,even_high_ln);
            if (null==result) {
                return sum(nums,target,odd_less,odd_high,odd_less_ln,odd_high_ln);
            }
            return result;
        } else {
            result = sum(nums,target,even_less,odd_high,even_less_ln,odd_high_ln);
            if (null==result) {
                return sum(nums,target,odd_less,even_high,odd_less_ln,even_high_ln);
            }
            return result;
        }
    }

    public int[] sum(int[] nums, int target, int[] ll, int[] hh, int l, int h) {
        if (l==0||h==0) {
            return null;
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                if ((nums[ll[i]]+nums[hh[j]])==target) {
                    return new int[]{ll[i],hh[j]};
                }
            }
        }
        return null;
    }

    /**
     * 寻找数组中n数相加结果为target的index
     * @param nums      数组
     * @param target    和
     * @param n         加数个数
     * @return
     */
    public int[] sum(int[] nums, int target, int n) {
        if (nums.length<n) {
            throw new IllegalArgumentException("No two sum solution");
        }
        for (int i = 0; i < n; i++) {

        }
        return  null;
    }



    public static void main(String[] args) {
        /*f();
        System.out.println("已经返回了");*/

        new ArrayList<Integer>().toArray(new Integer[0]);
    }

    public int[] twoSum2(int[] nums, int target) {



        return null;
    }

    class Note {
        int key;
        int value;
        int next;
    }

}
