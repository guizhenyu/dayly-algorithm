package com.gzy.algo.month202309;

public class September2MaximumSubarrayWithDeviceAndConquerApproach {


    public int maxSubArray(int[] nums) {


        return getInfos(nums, 0, nums.length - 1).subMax;
    }

    public class Status{

        /**
         * class Status represents the information within the range of l and r;
         * it has four field;
         * lMax represents the maximum sum of all subarray with l as the left endpoint.
         * rMax represents the maximum sum of all subarray with r as the right endpoint.
         * subMax represents the maximum sum of all subarray within the range.
         * sum represents the sum of all the nums within the range.
         */
        int lMax;
        int rMax;
        int subMax;
        int sum;

        public Status(int lMax, int rMax, int subMax, int sum){
            this.lMax = lMax;
            this.rMax = rMax;
            this.subMax = subMax;
            this.sum = sum;
        }
    }


    public Status getInfos(int[] nums, int l, int r){
        if (l == r){
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }

        int mid = (l + r) >> 1;
        Status leftStatus = getInfos(nums, l, mid);
        Status rightStatus = getInfos(nums, mid + 1, r);

        return pushUp(leftStatus, rightStatus);
    }

    private Status pushUp(Status l, Status r) {

        int sum = l.sum + r.sum;
        int lSum = Math.max(l.lMax, l.sum + r.lMax);
        int rSum = Math.max(r.rMax, l.rMax + r.sum);
        int subMax = Math.max(Math.max(l.subMax, r.subMax), l.rMax + r.lMax);
        return new Status(lSum, rSum, subMax, sum);
    }
}
