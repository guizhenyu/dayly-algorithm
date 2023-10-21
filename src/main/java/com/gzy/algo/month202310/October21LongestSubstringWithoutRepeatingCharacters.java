package com.gzy.algo.month202310;

import java.util.HashMap;

public class October21LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string s, return the length of longest substring without repeating characters.
     *
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        char[] chars = s.toCharArray();

        int start = 0;
        int longest = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            if (map.containsKey((int)chars[i])) {
                Integer preIndex = map.get((int)chars[i]);
                int len = i - start;
                start = start > preIndex? start : (preIndex + 1);
                longest = Math.max(longest, len);
            }
            map.put((int)chars[i], i);
        }

        int len = s.length() - start;

        return longest > len? longest : len;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";

        int i = lengthOfLongestSubstring(s);

        System.out.println(i);
    }
}
