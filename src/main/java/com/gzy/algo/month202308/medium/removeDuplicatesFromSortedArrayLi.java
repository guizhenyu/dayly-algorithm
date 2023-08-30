package com.gzy.algo.month202308.medium;

public class removeDuplicatesFromSortedArrayLi {

    public int removeDuplicates(int[] nums) {
        int cur = nums[0];
        int ans  = 1;
        int index = 1;
        int curRepeatTimes = 1;
        for (int i = 1;  i < nums.length; i++){
            ans++;
            if (nums[index] == cur){
                curRepeatTimes++;
            }else{
                if (curRepeatTimes >= 3){
                    int moveNums = curRepeatTimes - 2;
                    ans -= moveNums;
                    for (int j = index; j < nums.length; j++){
                        nums[j - moveNums] = nums[j];
                    }
                    index -= moveNums;
                }

                cur = nums[index];
                curRepeatTimes = 1;
            }
            index++;
        }

        if (curRepeatTimes > 2){
            ans -= (curRepeatTimes - 2);
        }

        return ans;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length <= 2){
            return 2;
        }

        int ans = 2;
        int index = 2;

        while (index < nums.length){
            if (nums[index] == nums[ans - 2]){
                index++;
            }else {
                nums[ans++] = nums[index++];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        removeDuplicatesFromSortedArrayLi function = new removeDuplicatesFromSortedArrayLi();
        int[] ints = {1, 1, 1, 2, 2, 3};
        int ans = function.removeDuplicates1(ints);
        System.out.println(ans);
    }

}
