package com.gzy.algo.month202308.day20230829;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * An anagram is a word or phrase formed by rearranging the letters of a different word or ho phrase, typically using all the
     * original letters exactly once.
     *
     * @param strs
     * @return
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];

            for (char cha : str.toCharArray()) {
                counts[cha - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }

            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());

            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println('b' - 'a');
    }
}
