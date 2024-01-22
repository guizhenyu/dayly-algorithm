package com.gzy.algo.month202401;

public class January22SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value,
     * return the index if the target is found. If not, return the index
     * where it would be if it were inserted in order.
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        return process(nums, target, 0, n - 1);
    }

    private int process(int[] nums, int target, int l, int r) {
        if (l == r) {
            if (nums[l] >= target) {
                return l;

            } else {
                return l + 1;
            }

        }


        int mid = (l + r) >> 1;

        if (nums[mid] > target) {
            return process(nums, target, l, mid - 1 >= l ? mid - 1 : l);
        } else if (nums[mid] < target) {
            return process(nums, target, mid + 1 <= r ? mid + 1 : r, r);
        } else {
            return mid;
        }

    }


    public static void main(String[] args) {
        System.out.println(1 >> 1);

        January22SearchInsertPosition fc = new January22SearchInsertPosition();
        int[] nums = {1, 3};
        int i = fc.searchInsert(nums, 2);
        System.out.println(i);

    }
}
