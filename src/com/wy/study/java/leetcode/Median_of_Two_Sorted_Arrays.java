package com.wy.study.java.leetcode;

import java.util.ArrayList;

/**
 * Created by wy_ms on 2017/05/28.
 */
public class Median_of_Two_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ln1= nums1.length, ln2=nums2.length, tln = ln1+ln2, mid1=tln%2==0?tln/2:tln/2+1,
                mid2=tln%2==0?mid1+1:mid1, result=0, l1=0, l2=0;
        while (true) {
            mid1--;
            mid2--;
            int val = 0;
            if (l1==ln1||l2==ln2) {
                int val1 = mid1>=0?l1==ln1?nums2[l2+mid1]:nums1[l1+mid1]:0;
                int val2 = l1==ln1?nums2[l2+mid2]:nums1[l1+mid2];
                return (result+val1+val2)/2.0;
            } else {
                int val1 = nums1[l1];
                int val2 = nums2[l2];
                if (val1<=val2) {
                    val = val1;
                    l1++;
                } else {
                    val = val2;
                    l2++;
                }
            }
            if (mid1==0) {
                result += val;
            }
            if (mid2==0) {
                result += val;
                return result / 2.0;
            }
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int ln1= nums1.length, ln2=nums2.length, tln = ln1+ln2, mid1=tln%2==0?tln/2:tln/2+1,
                mid2=tln%2==0?mid1+1:mid1;

        return findMedianSortedArrays(nums1,nums2,mid1,mid2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2, int mid1, int mid2) {
        int val1 = 0, val2 = 0;
        if (nums1.length==0) {
            val1 = nums2[mid1-1];
            val2 = nums2[mid2-1];
        }else if (nums2.length==0) {
            val1 = nums1[mid1-1];
            val2 = nums1[mid2-1];
        } else if (nums1[nums1.length-1]<=nums2[0]) {
            return findMedianSortedArraysResult(nums1,nums2,mid1,mid2);
        } else if (nums2[nums2.length-1]<=nums1[0]) {
            return findMedianSortedArraysResult(nums2,nums1,mid1,mid2);
        } else {
            for (int i = 0, j = 0; mid2 > 0; ) {
                mid1--;
                mid2--;

                int temval = 0;
                if (i < nums1.length && j < nums2.length) {
                    temval = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
                } else if (i == nums1.length) {
                    val1 = mid1 >= 0 ? nums2[j + mid1] : val1;
                    val2 = mid2 >= 0 ? nums2[j + mid2] : val2;
                    break;
                } else if (j == nums2.length) {
                    val1 = mid1 >= 0 ? nums1[i + mid1] : val1;
                    val2 = mid2 >= 0 ? nums1[i + mid2] : val2;
                    break;
                }
                if (mid1 == 0 && mid2 == 0) {
                    return temval;
                } else if (mid1 == 0) {
                    val1 = temval;
                } else if (mid2 == 0) {
                    val2 = temval;
                    break;
                }
            }
        }
        return (val1+val2)/2.0;
    }


    public double findMedianSortedArraysResult(int[] nums1, int[] nums2, int mid1, int mid2) {
        int val1 = nums1.length>=mid1?nums1[mid1-1]:nums2[mid1-1-nums1.length];
        int val2 = nums1.length>=mid2?nums1[mid2-1]:nums2[mid2-1-nums1.length];
        return (val1+val2)/2.0;
    }

    public static void main(String[] args) {
        /*int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        Median_of_Two_Sorted_Arrays mots = new Median_of_Two_Sorted_Arrays();
        double mid = mots.findMedianSortedArrays1(nums1,nums2);
        System.out.println(mid);
        assert mid==2;*/
        int[] nums = new int[]{1,2,5,8,10,12,16,18,19,25,30,41,45,50,58,81};
        int index = binSearch(nums, 5);
        System.out.println(index);
        assert index==2;
    }


    public  static int binSearch(int[] nums, int key) {
        int mid = nums.length/2;
        if (key==nums[mid]) {
            return mid;
        }
        int start = 0;
        int end = nums.length-1;
        while (start<=end) {
            mid = (end-start)/2+start;
            if (key<nums[mid]) {
                end = mid-1;
            } else if (key>nums[mid]) {
                start = mid+1;
            } else
                return mid;
        }
        return -1;
    }

}
