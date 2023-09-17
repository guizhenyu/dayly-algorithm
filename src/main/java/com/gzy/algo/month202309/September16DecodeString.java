package com.gzy.algo.month202309;

import java.util.Stack;

public class September16DecodeString {

    /**
     *  Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
     *
     * The test cases are generated so that the length of the output will never exceed 105.
     *
     * @param s
     * @return
     */

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<String> stackStr = new Stack<>();
        char[] chars = s.toCharArray();

        for (int index = 0; index <= chars.length - 1; index++){
            char cha = chars[index];
            if (cha == ']'){
                String cur = "";
                String temp = "";
                while (!stack.isEmpty()){
                    Character popCha = stack.pop();
                    if (popCha >= 48 && popCha <= 57){
                        Stack<Character> numStack = new Stack<>();
                        numStack.push(popCha);
                        if(!stack.isEmpty()){
                            Character peek = stack.peek();
                            while (peek >= 48 && peek <= 57){
                                stack.pop();
                                numStack.push(peek);
                                if (stack.isEmpty()){
                                    break;
                                }
                                peek = stack.peek();

                            }
                            if (peek == '['){
                                stack.pop();
                            }
                        }

                        StringBuilder timesSb = new StringBuilder();
                        while (!numStack.isEmpty()){
                            timesSb.append(numStack.pop());
                        }

                        int times = Integer.valueOf(timesSb.toString());
                        while (times > 0){
                            temp = temp + cur;
                            times--;
                        }
                        stackStr.push(temp);
                        stack.push('#');
                        break;
                    }
                    else if (popCha == '#'){
                        String preStr = stackStr.pop();
                        cur = preStr + cur;
                    }else if(popCha == '['){
                        continue;
                    }else{
                        cur = popCha + cur;
                    }
                }
            }
            else {
                stack.push(cha);
            }
        }
        String ans = "";

        while (!stack.isEmpty()){
            Character popCha = stack.pop();
            if (popCha == '#'){
                ans = stackStr.pop() + ans;
            }else {
                ans = popCha + ans;
            }

        }
        return ans;
    }


    public void note(){
//        if (cha >= 48 && cha <= 57){
//            // 数字
//            stack.push(cha);
//        } else if(cha == '['){
//            continue;
//        } else if (cha == ']'){
//            Character pop = stack.pop();
//            Stack<Character> stackTemp = new Stack<>();
//            while (pop >= 97  && pop <= 122){
//                stackTemp.push(pop);
//                pop = stack.pop();
//            }
//
//            StringBuilder sbTemp = new StringBuilder();
//            while (!stackTemp.isEmpty()){
//                sbTemp.append(stackTemp.pop());
//            }
//
//            String s1 = sbTemp.toString();
//            sbTemp = new StringBuilder();
//            for (int i = 0; i < (pop - 48); i++){
//                sbTemp.append(s1);
//            }
////                if(){
////
////                }
//
//
//        }else {
//            // 字母
//
//            if (stack.isEmpty()){
//                sb.append(cha);
//                continue;
//            }
//            stack.push(cha);
//zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
//zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef
//        }
    }

    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s1 = decodeString(s);
        System.out.println(s1);
//        System.out.println(i 'b');
    }
}
