package com.gzy.algo.month202309;

public class September13JumpGameII {

    public static int jump(int[] nums) {

        int end = 0;
        int maxPosition = 0;
        int step = 0;

        for (int i = 0; i < nums.length - 1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);

            if (i == end){
                end = maxPosition;
                step++;
            }

        }
        return step;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        int jump = jump(nums);
        System.out.println(jump);
    }

}
