package com.gzy.algo.month202403;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public class Node{
        public int pass;
        public int end;
        public Map<Integer, Node> nexts;
        public Node(){
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        if (word == null || word.length() == 0){
            return;
        }
        char[] chars = word.toCharArray();
        Node node = root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < chars.length; i++){
             index = (int)chars[i];
             if (node.nexts.get(index) == null){
                node.nexts.put(index, new Node());
             }
             Node next = node.nexts.get(index);
             next.pass++;
             node = next;
        }
        node.end++;
    }

    public boolean search(String word){

        return iterate(word).end > 0;
    }

    public Node iterate(String word){
        if (word == null || word.length() == 0){
            return new Node();
        }
        char[] chars = word.toCharArray();
        Node node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++){
            index = (int)chars[i];
            if (node.nexts.get(index) == null){
                return new Node();
            }
            node = node.nexts.get(index);
        }
        return node;
    }

    public boolean startsWith(String prefix){
        return iterate(prefix).pass > 0;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "first");
        map.put(2, "second");
        Integer num1 = new Integer(1);
        Integer num2 = new Integer(2);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(map);
    }
}
