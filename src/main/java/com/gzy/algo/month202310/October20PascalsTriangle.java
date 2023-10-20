package com.gzy.algo.month202310;

import java.util.ArrayList;
import java.util.List;

public class October20PascalsTriangle {


    /**
     * Given an integer rowRows, return the first numRows of Pascal's triangle,
     * In Pascal's Triangle , each nums is the sum of two nums directly above it as shown.
     *
     * @param rowNum
     * @return
     */
    public List<List<Integer>> generate(int rowNum){
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> firstList = new ArrayList<>(1);
        firstList.add(1);
        ans.add(firstList);
        for (int row = 1; row < rowNum; row++){
            List<Integer> preList = ans.get(row - 1);
            List<Integer> list = new ArrayList<>(row + 1);
            for (int i = 0; i <= row; i++){

                if (i == 0 || i == row){
                    list.add(1);
                }else{
                    int num = preList.get(i - 1) + preList.get(i);
                    list.add(num);
                }
            }

            ans.add(list);

        }


        return ans;
    }
}
