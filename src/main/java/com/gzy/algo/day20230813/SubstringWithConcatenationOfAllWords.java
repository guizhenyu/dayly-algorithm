package com.gzy.algo.day20230813;

import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    /**
     * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
     *
     *
     * You are given a string s and an array of strings words. All the strings of words are of the same length.
     *
     * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
     *
     * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
     * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * s and words[i] consist of lowercase English letters.
     *
     */

    public List<Integer> findSubstring(String s, String[] words){
        int subLen = words[0].length();
        int subLens = words.length;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + subLen * subLens <= s.length(); i++){
            int matchBIt = 0;
            matchBIt = match(s, i, i + subLen * subLens, subLen, words, matchBIt);

            if (matchBIt == Math.pow(2, subLens) - 1){
                ans.add(i);
            }
        }

        return ans;
    }



    public int match(String s, int beginIndex, int endIndex, int step, String[] words, int matchBitmap){

        for(int i = beginIndex; i < endIndex; i += step){
            String sub = s.substring(i, i + step);

            boolean isMatch = false;
            for (int j = 0; j < words.length; j++){
                if ((matchBitmap & (int)Math.pow(2, j)) >> j == 1){
                    continue;
                }
                if (sub.equals(words[j])){
                    matchBitmap |= (int)Math.pow(2, j);
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch){
                break;
            }
        }
        return matchBitmap;
    }


    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords sb = new SubstringWithConcatenationOfAllWords();
        String[] words = {"word", "good", "best", "good"};
        List<Integer> ans = sb.findSubstring("wordgoodgoodgoodbestword", words);
        for (Integer rs : ans){
            System.out.println(rs);
        }
    }

}
