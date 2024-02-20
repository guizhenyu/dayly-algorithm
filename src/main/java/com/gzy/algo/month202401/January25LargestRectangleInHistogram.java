package com.gzy.algo.month202401;

import java.util.Stack;

public class January25LargestRectangleInHistogram {

    /**
     * Given an array of integers heights representing the histogram's
     * bar height where the width of each bar is 1, return the area of the
     * largest rectangle in the histogram.
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights){

        Stack<Integer> stack = new Stack<Integer>();

        int max = Integer.MIN_VALUE;

        stack.push(0);

        for (int i = 1; i < heights.length; i++){
            int h = heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= h){
                Integer index = stack.pop();
                int l = stack.isEmpty()? 0 : stack.peek() + 1;
                int rectangle = (i - l) * heights[index];
                max = Math.max(max, rectangle);
            }

            stack.push(i);
        }

        int r = heights.length;
        while (!stack.isEmpty()){
            int index = stack.pop();
//

            int l = stack.isEmpty()? 0 : stack.peek() + 1;
            int rectangle = (r - l) * heights[index];
            max = Math.max(max, rectangle);


        }
        return max;
    }

//    public int largestRectangleArea(int[] heights){
//
//        Stack<Integer> stack = new Stack<Integer>();
//
//        int max = Integer.MIN_VALUE;
//
//        stack.push(0);
//
//        for (int i = 1; i < heights.length; i++){
//            int h = heights[i];
//
//            while (!stack.isEmpty() && heights[stack.peek()] >= h){
//                Integer index = stack.pop();
////                int rectangle = 0;
////                if (stack.isEmpty()){
////                    rectangle = heights[index] * i;
////                }else {
////                    int l =  stack.peek();
////                    rectangle = (index - l + 1) * Math.max(heights[l], heights[i]);
////                }
////
////                max = Math.max(max, Math.max(heights[index], rectangle));
//                int l = stack.isEmpty()? 0 : stack.peek();
//                int rectangle = (i - l - 1) * heights[index];
//                max = Math.max(max, rectangle);
//            }
//
//            stack.push(i);
//        }
//
//        int r = heights.length;
//        while (!stack.isEmpty()){
//            int index = stack.pop();
////            int rectangle = 0;
////            if (stack.isEmpty()){
////                rectangle = r * heights[index];
////            }else {
////                int l = stack.peek();
////
////                if (heights[l] == 0){
////                    rectangle = (r - l - 1) * heights[index];
////                }else {
////                    rectangle = (r - l) * heights[l];
////                }
////
////            }
//
//            int l = stack.isEmpty()? 0 : stack.peek();
//            int rectangle = (r - l) * heights[index];
//            max = Math.max(max, rectangle);
//
////            max = Math.max(max, Math.max(heights[index], rectangle));
//
//        }
//        return max;
//    }


    public static void main(String[] args) {


        int[] heights = {2,1,5,6,2,3};
        January25LargestRectangleInHistogram fc =
                new January25LargestRectangleInHistogram();
        int i = fc.largestRectangleArea(heights);
        System.out.println(i);
    }

}
