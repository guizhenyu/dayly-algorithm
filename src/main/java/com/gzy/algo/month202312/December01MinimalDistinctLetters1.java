package com.gzy.algo.month202312;

import java.util.*;

public class December01MinimalDistinctLetters1 {


    private int countDistinct(String P, String Q) {
        boolean[] present = new boolean[26];
        for (char c : P.toCharArray()) {
            present[c - 'a'] = true;
        }
        for (char c : Q.toCharArray()) {
            present[c - 'a'] = true;
        }
        int count = 0;
        for (boolean p : present) {
            if (p) count++;
        }
        return count;
    }

    public int solution(String P, String Q) {
        int n = P.length();
        int numDistinct = countDistinct(P, Q); // count the number of distinct letters in P and Q
        int lo = 1, hi = numDistinct;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canConstruct(P, Q, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canConstruct(String P, String Q, int numDistinct) {
        int n = P.length();
        Set<Character> distinct = new HashSet<>();
        for (char c : P.toCharArray()) {
            if (!distinct.contains(c)) {
                distinct.add(c);
                if (distinct.size() == numDistinct) {
                    if (checkSubset(P, Q, distinct)) {
                        return true;
                    }
                    distinct.remove(c);
                }
            }
        }
        for (char c : Q.toCharArray()) {
            if (!distinct.contains(c)) {
                distinct.add(c);
                if (distinct.size() == numDistinct) {
                    if (checkSubset(P, Q, distinct)) {
                        return true;
                    }
                    distinct.remove(c);
                }
            }
        }
        return false;
    }
    private boolean checkSubset(String P, String Q, Set<Character> subset) {
        int n = P.length();
        BitSet presentP = new BitSet();
        BitSet presentQ = new BitSet();

        for (int i = 0 ; i < n; i++){
            Character chaP = P.charAt(i);
            Character chaQ = Q.charAt(i);

            if (subset.contains(chaP)){
                presentP.set(i);
            }
            if (subset.contains(chaQ)){
                presentQ.set(i);
            }

        }
        presentP.or(presentQ);

        for (int i = 0; i < n; i++){
            if (!presentP.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("21343");
        December01MinimalDistinctLetters1 december01MinimalDistinctLetters1 = new December01MinimalDistinctLetters1();
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(5);
        System.out.println(bitSet.get(1));

    }
}
