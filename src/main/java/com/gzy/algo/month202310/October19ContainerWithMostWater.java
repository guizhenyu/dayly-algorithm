package com.gzy.algo.month202310;

public class October19ContainerWithMostWater {

    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
     * of the i-th line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < r){
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }

        }

        return ans;

    }
}
