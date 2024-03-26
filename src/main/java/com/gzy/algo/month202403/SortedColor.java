package com.gzy.algo.month202403;

import java.util.HashMap;
import java.util.Map;

public class SortedColor {

    public void sortColors(int[] nums) {

        int n = nums.length;
        int p0 = 0; // 0的右边界索引
        int p1 = 0; // 1的右边界索引
        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                swap(nums, i, p0++);
                p1++;
            }else if(nums[i] == 1){
                swap(nums, i, p1++);
            }
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                swap(nums, p1++, i);
            }else if(nums[i] == 0){
                swap(nums, i, p0);
                if(p0 < p1){
                    swap(nums, i, p1);
                }

                p0++;
                p1++;
            }
        }
    }


    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;

        for (int i = 0; i <= p2; i++){
            while (i <= p2 && nums[p2] == 2){
                swap(nums, p2--, i);
            }
            if (nums[i] == 0){
                swap(nums,p0++, i);
            }
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("dsf", "sdfds");
        map.put("dsf1", "sdfds1");



    }

    public class Report{
        int age;
        String name;
        Map<String, String> data;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, String> getData() {
            return data;
        }

        public void setData(Map<String, String> data) {
            this.data = data;
        }
    }
}
