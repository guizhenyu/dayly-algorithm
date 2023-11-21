package com.gzy.algo.month202311;

public class November21CanIWin {

    public boolean canIWin(int maxChoosableInteger, int desireTotal){

        if (maxChoosableInteger >= desireTotal){
            return true;
        }

        if ((maxChoosableInteger * (maxChoosableInteger + 1) >> 1) < desireTotal){
            return false;
        }

        int[] nums = new int[maxChoosableInteger];

        for (int i = 0; i < maxChoosableInteger; i++){
            nums[i] = i + 1;
        }
        return process(nums, desireTotal);
    }

    public boolean process(int[] nums, int rest){
        if (rest <= 0){
            return false;
        }
        for (int i = 0; i < nums.length; i++){

            if (nums[i] != -1){
                int cur = nums[i];
                nums[i] = -1;
                boolean next = process(nums, rest - cur);
                nums[i] = cur;
                if (!next){
                    return true;
                }

            }

        }
        return false;
    }


    public boolean canIWinWithDP(int maxChoosableInteger, int desireTotal){
        if (maxChoosableInteger >= desireTotal){
            return true;
        }

        if ((maxChoosableInteger * (maxChoosableInteger + 1) >> 1) < desireTotal){
            return false;
        }

        int[] dp = new int[1 << maxChoosableInteger];

        return processWithDP(maxChoosableInteger, 0, desireTotal, dp);
    }

    private boolean processWithDP(int maxNum, int status, int rest, int[] dp) {

        if (dp[status] != 0){
            return dp[status] == 1? true : false;
        }

        boolean ans = false;
        if (rest > 0){
            for (int i = 1; i <= maxNum; i++){

                if (((1 << i) & status) == 0){
                    if (!processWithDP(maxNum, status | (1 << i), rest - i, dp)){
                        ans = true;
                        break;
                    }
                }

            }
        }



        dp[status] = ans? 1 : -1;
        return ans;
    }


}
