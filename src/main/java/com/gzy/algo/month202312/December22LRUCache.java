package com.gzy.algo.month202312;

import java.util.HashMap;
import java.util.Map;


public class December22LRUCache {


    /**
     *
     * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
     *
     * Implement the LRUCache class:
     *
     * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
     * int get(int key) Return the value of the key if the key exists, otherwise return -1.
     * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
     * The functions get and put must each run in O(1) average time complexity.
     *
     *
     */

    public LRUCache cache;

    public December22LRUCache(int capacity){

        cache = new LRUCache(capacity);
    }


    public Integer get(int key){
        return cache.get(key);
    }


    public void put(int key, int value){
         cache.put(key, value);
    }


    class LRUCache {

        public Node headSentinal;

        public Node tailSentinal;

        public Map<Integer, Node> map;

        public Integer capacity;

        public Integer count;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            headSentinal = new Node();
            tailSentinal = new Node();
            headSentinal.next = tailSentinal;
            tailSentinal.pre = headSentinal;
            count = 0;
        }

        public int get(int key) {
            if (map.get(key) == null){
                return -1;
            }

            Node node = map.get(key);

            removeToHead(node);

            return node.value;

        }

        private void removeToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void addToHead(Node node){
            node.next = headSentinal.next;
            headSentinal.next.pre = node;
            headSentinal.next = node;
            node.pre = headSentinal;
        }

        public void removeNode(Node node){
            Node nodePre = node.pre;
            nodePre.next = node.next;
            node.next.pre = nodePre;
        }

        public Node removeTail(){
            Node ans = tailSentinal.pre;
            removeNode(ans);
            return ans;
        }

        public void put(int key, int value) {

            if (map.get(key) != null){

                Node node = map.get(key);
                node.value = value;
                removeToHead(node);
                return;
            }
            // 去除最远节点
            if (count == capacity){
                Node node = removeTail();
                map.remove(node.key);
                --count;
            }

            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
            count++;
        }
    }



    public class Node {
        Node next;

        Node pre;
        Integer key;

        Integer  value;

        public Node(){

        }

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }


    }



    public static void main(String[] args) {
        December22LRUCache december22LRUCache = new December22LRUCache(2);

        december22LRUCache.put(1, 1);
        december22LRUCache.put(2, 2);
        Integer integer = december22LRUCache.get(1);

        System.out.println(integer);
    }


}
