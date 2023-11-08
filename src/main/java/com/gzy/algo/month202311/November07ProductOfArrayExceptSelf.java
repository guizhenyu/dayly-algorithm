package com.gzy.algo.month202311;

public class November07ProductOfArrayExceptSelf {


    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of
     * all the elements of nums except num[i]
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * @param nums
     * @return
     */
    public static int[] productOfArrayExceptSelf(int[] nums){
        int n = nums.length;
        int[] lToR = new int[n];
        lToR[0] = nums[0];

        int[] rToL = new int[n];

        rToL[n - 1] = nums[n - 1];
        int[] ans = new int[n];
        for (int l = 1; l < n; l++){
            lToR[l] = lToR[l - 1] * nums[l];
        }
        for (int r = n - 2; r >= 0; r--){
            rToL[r] = rToL[r + 1] * nums[r];
        }

        for (int i = 0 ; i < n; i++){
            ans[i] = (i - 1 >= 0? lToR[i - 1]: 1) * (i + 1 < n? rToL[i + 1]: 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        productOfArrayExceptSelf(nums);
    }

}
