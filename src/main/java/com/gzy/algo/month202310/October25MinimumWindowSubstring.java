package com.gzy.algo.month202310;

import java.util.HashMap;
import java.util.Map;

public class October25MinimumWindowSubstring {

    Map<Character, Integer> sourceMap = new HashMap<>();
    Map<Character, Integer> targetMap = new HashMap<>();


    /**
     * Given two strings s and t of length m and n respectively, return the minimum window substring of s
     * such that every character in t(including duplicates) is included in the window.
     * If there is no such substring, return "".
     * The testcases will be generated such that the answer is unique.
     * <p>
     * <p>
     * Could you find an algorithm that runs in O(m + n) time?
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        for (int i = 0; i < lenT; i++) {
            Character cha = t.charAt(i);
            targetMap.put(cha, targetMap.getOrDefault(cha, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR= -1;
        int l = 0;
        for (int i = 0; i < lenS; i++){
            Character cha = s.charAt(i);
            if(!targetMap.containsKey(cha)){
                continue;
            }
            sourceMap.put(cha, sourceMap.getOrDefault(cha, 0) + 1);
            while (check() && l <= i){
                if (i - l + 1 < min){
                    ansR = i + 1;
                    ansL = l;
                    min = ansR - ansL;
                }
                Character lCha = s.charAt(l);

                if(targetMap.containsKey(lCha)){
                    sourceMap.put(lCha, sourceMap.get(lCha) - 1);
                }
                ++l;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }

    /**
     * check if the sourceMap contains all the keys in targetMap and sourceMap's value is greater than targetMap's value or equals
     *
     * @return
     */
    public boolean check() {
        for (Character key : targetMap.keySet()) {
            if (sourceMap.getOrDefault(key, 0) < targetMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
