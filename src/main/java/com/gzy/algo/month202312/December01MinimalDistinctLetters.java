package com.gzy.algo.month202312;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class December01MinimalDistinctLetters {


    /**
     * We are given two strings P and Q, each consisting of N lowercase English letters.
     * For each position in the strings, we have to choose one letter from either P or Q,
     * in order to construct a new string S, such that the number of distinct letters in S is minimal.
     * N is an integer within the range [1..200,000];
     * strings P and Q are both of length N;
     * strings P and Q are made only of lowercase letters (a−z);
     * strings P and Q contain a total of at most 20 distinct letters.
     * @param P
     * @param Q
     * @return
     */
    public int solution(String P, String Q) {
        // Implement your solution here
//        Map<Character, Integer> cache = new HashMap<>();
        Map<String, Integer> cacheAnswer = new HashMap<>();
        int process = process(P, Q, 0, "", cacheAnswer);
        return process;
    }


    public int dp(String P, String Q){
        int len = P.length();

        int[] dpP = new int[len];
        int[] dpQ = new int[len];
        Set<Character> cacheP = new HashSet<>();
        Set<Character> cacheQ = new HashSet<>();
        dpP[0] = 1;
        cacheP.add(P.charAt(0));
        dpQ[0] = 1;
        cacheQ.add(Q.charAt(0));

        for (int i = 1; i < len; i++){
            Character chaP = P.charAt(i);
            Character chaQ = Q.charAt(i);
            if (cacheP.contains(chaP) || cacheP.contains(chaQ)){
               dpP[i] = dpP[i - 1];
            }else {
                cacheP.add(chaP);
                dpP[i] = dpP[i - 1] + 1;
            }

            if (cacheQ.contains(chaP) || cacheQ.contains(chaQ)){
                dpQ[i] = dpQ[i - 1];
            } else {
                cacheQ.add(chaQ);
                dpQ[i] = dpQ[i - 1] + 1;
            }
        }


        return Math.min(dpP[len - 1], dpQ[len - 1]);
    }

    private int process(String p, String q, int index,  String str, Map<String, Integer> cacheAnswer) {


        if (index == p.length()){
            return countStringDistinct(str);
        }
        if (cacheAnswer.containsKey(str)){
            return cacheAnswer.get(str);
        }

        Character pCha = p.charAt(index);
        Character qCha = q.charAt(index);

        str += pCha;
        int p1 = process(p, q, index + 1
                , str, cacheAnswer);
        str = str.substring(0, str.length() - 1);

        str += qCha;
        int p2= process(p, q, index + 1, str, cacheAnswer);
        str = str.substring(0, str.length() - 1);


        cacheAnswer.put(str, Math.min(p1, p2));
        return cacheAnswer.get(str);
    }

    public int countStringDistinct(String str){
        Set<Character> set = new HashSet<>();
        for (Character character : str.toCharArray()){
            set.add(character);
        }
        return set.size();
    }



    public static final String S = "qwertyuiopasdfghjklzxcvbnm";


    public static void main(String[] args) {
        December01MinimalDistinctLetters fc = new December01MinimalDistinctLetters();

        int times = 10_000;
        String s = "qwertyuiopasdfghjklzxcvbnm";
        int MAX_LEN = 200000;
        for (int i = 0; i <= times; i++){
            int len = (int )(MAX_LEN * Math.random()) + 1;
            String p = randomStr(len);
            String q = randomStr(len);

            int pAns = fc.solution(p, q);
            int qAns = fc.dp(p, q);
            if (pAns != qAns){
                System.out.println("Error");
                System.out.println(pAns + ": "+ qAns);
            }

        }



        int solution = fc.solution("abc", "bcd");
        System.out.println(solution);
//        String ss = "sdgdf";
//        String s2 = "";
//
//        s2 += ss.charAt(1);
//        System.out.println(s2);
//        System.out.println(s2.substring(0,s2.length() - 1));
    }


    public static  String randomStr(int len){
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < len; i++){

            int index =  (int )(26 * Math.random());
//            System.out.println(index);
            sb.append(S.charAt(index));

        }

        return sb.toString();
    }
}
