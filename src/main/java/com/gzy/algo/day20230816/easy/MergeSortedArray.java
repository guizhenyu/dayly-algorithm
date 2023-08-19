package com.gzy.algo.day20230816.easy;

public class MergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n){
        /**
         * Because we must come up with an algorithm that runs in O(m + n) time
         *
         */
        int len = nums1.length - 1;
        while (len >= 0){
            if (m - 1< 0){
                nums1[len] = nums2[n - 1];
                n--;
            }else if (n - 1< 0){
                nums1[len] = nums1[m - 1];
                m--;
            }else{
                if (nums1[m - 1] >= nums2[n - 1]){
                    nums1[len] = nums1[m - 1];
                    m--;
                }else {
                    nums1[len] = nums2[n - 1];
                    n--;
                }
            }

            len--;
        }

    }
}
