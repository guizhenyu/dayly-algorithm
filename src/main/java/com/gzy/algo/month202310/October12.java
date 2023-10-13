package com.gzy.algo.month202310;



public class October12 {

    /**
     * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the
     * elements in both subsets is equal or false otherwise.
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums){

        return process(nums, 0, 0, 0);

    }

    private boolean process(int[] nums, int i, int i1, int i2) {

        if (i == nums.length){
            if (i1 == i2){
                return true;
            }else {
                return false;
            }
        }

        boolean ans = false;

        ans |= process(nums, i+ 1, i1 + nums[i], i2);
        ans |= process(nums, i+ 1, i1, i2 + nums[i]);


        return ans;
    }

    public boolean dp(int[] nums){
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        int half = sum / 2;
        if(half * 2 != sum){
            return false;
        }

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][half + 1];

        for (int i = 0; i <= n; i++){
            dp[i][half] = true;
        }

        for (int i = n - 1; i >= 0; i--){
            for (int j = half - 1; j >= 0; j--){

                dp[i][j] |= dp[i + 1][j];
                if (j + nums[i] <= half){
                    dp[i][j] |= dp[i + 1][j + nums[i]];
                }
            }
        }

        return dp[0][0];
    }

    public static boolean dpOptimize(int[] nums){
        int sum = 0;
        int max = 0;
        for (int num: nums){
            sum += num;
            max = Math.max(max, num);
        }


        if(sum % 2 != 0){
            return false;
        }

        int half = sum / 2;

        if (max > half){
            return false;
        }
        int n = nums.length;

//        boolean[][] dp = new boolean[n + 1][half + 1];
        boolean[] dp = new boolean[half + 1];
        dp[half] = true;

        for (int i = n - 1; i >= 0; i--){
            for (int j = half - 1; j >= 0; j--){

                if (j + nums[i] <= half){
                    dp[j] |= dp[j + nums[i]];
                }
            }
        }

        return dp[0];
    }

    private boolean process1(int[] nums, int index, int sum, int half) {

        if (sum == half){
            return true;
        }

        if (index == nums.length){
            return false;
        }

        boolean ans = false;
        ans |= process1(nums, index + 1, sum, half);
        ans |= process1(nums, index + 1, sum + nums[index], half);

        return ans;
    }


    public static void main(String[] args) {

        int[] nums = {2,2,3,5};

        boolean ans = dpOptimize(nums);
        System.out.println(ans);
    }
}
