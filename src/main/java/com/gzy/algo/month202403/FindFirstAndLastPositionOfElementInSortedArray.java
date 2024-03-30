package com.gzy.algo.month202403;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * Given an array of integers nums sorted in non-decreasing order,
     * find the starting and ending position of given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     * we can use a binary search approach to solve this problem.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target){
        int leftIndex = searchEqualBoundaryIndex(nums, target, true);
        if (leftIndex == -1){
            // if the left boundary does't exist,
            // so the right boundary does't exist too.
            // we can return the ans [-1,-1;
            return new int[]{-1, -1};
        }

        int rightIndex = searchEqualBoundaryIndex(nums, target, false);

        return new int[]{leftIndex, rightIndex};
    }

    /**
     * This method can find the index of the left or right boundary in the nums array
     * equal to the target num.
     * @param nums
     * @param target
     * @param leftOrRight this parameter represents left boundary or right boundary
     * @return
     */
    public int searchEqualBoundaryIndex(int[] nums, int target, boolean leftOrRight){
        //  we can use dual  pointers to narrow down the range
        int left = 0, right = nums.length - 1;
        int mid = 0;
        // default result index is -1
        int ans = -1;
        while(left <= right){
            // calculate the mid index depend on the left and right
            mid = (left + right) >> 1;

            if(nums[mid] > target){
                // if the nums in the mid index of nums array is greater than target
                // as we want to find the equal index,
                // so here we narrow right value by set mid - 1 to it
                right = mid - 1;
            }
            if(nums[mid] < target){
                // if the nums in the mid index of nums array is less than target
                // as we want to find the equal index,
                // so here we narrow left value by set mid + 1 to it
                left = mid + 1;
            }
            if(nums[mid] == target){
                // as we want to find the equal index boundary
                // though here we can't figure whether the mid index is the left boundary or
                // right boundary
                // we can set ans equal to mid first
                ans = mid;
                // then we can change the left and right index to figure out the specific
                // ans
                if (leftOrRight){
                    // as we want to find the left boundary
                    // nums[mid] == target, the ans is less and equal than mid
                    // so here we set right equal to mid - 1 to narrow the range.
                    right = mid - 1;
                }else {
                    // as we want to find the right boundary
                    // the ans is greater and equal than mid
                    // so here we set the left equal to mid + 1 to narrow the range.
                    left = mid + 1;
                }
            }
        }


        return ans;

    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        FindFirstAndLastPositionOfElementInSortedArray fc =
                new FindFirstAndLastPositionOfElementInSortedArray();

        int[] ints = fc.searchRange(nums, target);
        System.out.println(ints);
    }
}
