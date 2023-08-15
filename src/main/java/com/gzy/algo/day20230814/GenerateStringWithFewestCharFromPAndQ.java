package com.gzy.algo.day20230814;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GenerateStringWithFewestCharFromPAndQ {

    public  static int solution1(String P, String Q) {
        // Implement your solution here

        // 记录词频
        Map<Integer, Integer> cacheMap = new HashMap<>();

        //最终存放选中的char,
        Map<Integer, Integer> resMap = new HashMap<>();

        // 用栈记录P中每个词初出现时对应的索引位置
        Map<Integer, Stack<Integer>> positionMapP = new HashMap<>();
        // 同上
        Map<Integer, Stack<Integer>> positionMapQ = new HashMap<>();

        int N = P.length();
        //  初始化词频操作和记录位置
        for (int i = 0; i < N; i++){
            int num = (int)P.charAt(i);
            cacheMap.put(num, cacheMap.getOrDefault(num, 0) + 1);
            Stack<Integer> stack = positionMapP.get(num);
            if (stack == null){
                stack = new Stack<>();
            }
            stack.push(i);
            positionMapP.put(num, stack);
        }
        for (int i = 0; i < N; i++){
            int num = (int)Q.charAt(i);
            cacheMap.put(num, cacheMap.getOrDefault(num, 0) + 1);
            Stack<Integer> stack = positionMapQ.get(num);
            if (stack == null){
                stack = new Stack<>();
            }
            stack.push(i);
            positionMapQ.put(num, stack);
        }


        // 从索引 N - 1到 0 遍历
        for (int i = N - 1; i >= 0; i--){
            // 这边是字符直接转int,  a -> 97 依次类推
            int pNum = (int)P.charAt(i);
            // 词频
            int pNumCount = cacheMap.get(pNum);
            // 位置栈
            Stack<Integer> stackP = positionMapP.get(pNum);
            stackP.pop();
            int qNum = (int)Q.charAt(i);
            int qNumCount = cacheMap.get(qNum);
            Stack<Integer> stackQ = positionMapQ.get(qNum);
            stackQ.pop();

            // 这边比较的是当P[i] 和Q[i]的词频相等，并且大于1时的, 取间隔较远的那个字符
            // 例如： P = "axxz" Q="yzwy"   当i = 3时， P[3] = 'z', Q[3]='y', 他们得词频都是2， 这时由于z的下一次出现的位置是1， 而y下一次出现的位置是0， 所以选择y
            if (pNumCount == qNumCount && pNumCount > 1){
                int nextPIndex = stackP.isEmpty()? (positionMapQ.get(pNum).isEmpty()? 0:  positionMapQ.get(pNum).peek()) : stackP.peek();
                int nextQIndex = stackQ.isEmpty()? (positionMapP.get(qNum).isEmpty()? 0 : positionMapP.get(qNum).peek()):stackQ.peek();

                // 这边只考虑 Q[i] 在 P[i]前面， 因为默认是取的P[i]
                if (nextPIndex > nextQIndex){
                    resMap.put(qNum, 1);
                    continue;
                }
            }
            // 之前已经放到结果集里面了
            if (resMap.containsKey(pNum) || resMap.containsKey(qNum)){
                continue;
            }

            // 比较词频，选择词频大的
            if (pNumCount >= qNumCount){
                if (!resMap.containsKey(pNum)){
                    resMap.put(pNum, 1);
                }
               if (pNumCount > 1){
                   cacheMap.put(pNum, pNumCount - 1);
               }else {
                   if (!resMap.containsKey(pNum)){
                       resMap.put(pNum, 1);
                   }
               }
            }else {
                if (!resMap.containsKey(pNum)){
                    resMap.put(qNum, 1);
                }
                if (qNumCount > 1){
                    cacheMap.put(qNum, qNumCount - 1);
                }else {
                    if (!resMap.containsKey(qNum)){
                        resMap.put(qNum, 1);
                    }
                }
            }
        }


        return resMap.size();

    }






    public static void main(String[] args) {
        String P = "abc";
        String Q = "abc";


        int i = solution1(P, Q);
        System.out.println(i);

    }




}
