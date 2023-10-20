package com.gzy.algo.month202310;

public class October20MoveZeros {

    /**
     * given you an integer array nums, moved all 0's to the end of it maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     * @param nums
     */
    public void moveZeros(int[] nums){
            int n = nums.length;

            int l = 0;
            int r = n - 1;

            while (l < r){
                if (nums[l] == 0){
                    shiftArray(nums, l, r);
                    nums[r] = 0;
                    r--;
                }else {
                    l++;
                }
            }
        }

        public void shiftArray(int[] nums, int index, int r){

            for (int i = index; i < r; i++){
                nums[i] = nums[i + 1];
            }
        }
}
