package com.gzy.algo.month202309;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class September19TopKFrequentElements {


    /**
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++){
            Integer key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        TopKHeap topKHeap = new TopKHeap(map.keySet().size());
        for (Integer key : map.keySet()){
            topKHeap.push(new Node(key, map.get(key)));
        }
        int[] ans = new int[k];
        while (k > 1){
            ans[k - 1] = topKHeap.pop();
            k--;
        }
        ans[0] = topKHeap.pop();
        return ans;
    }


    class Node implements Comparator<Node> {
        int val;
        int times;

        public Node(int val, int times){
            this.val = val;
            this.times = times;
        }


        @Override
        public int compare(Node o1, Node o2) {
            return o1.times - o1.times;
        }
    }

    class TopKHeap{
        int capacity;
        int size;
        Node[] arrays;
        public TopKHeap(int capacity){
            this.capacity = capacity;
            this.arrays = new Node[capacity];
            this.size = 0;
        }

        public void push(Node node){
            if (size == capacity){
                return;
            }
            arrays[size] = node;
            heapInsert(size++);

        }

        private void heapInsert(int index) {

            while (index > 0){
                int parentIndex = (index - 1) / 2;

                if (arrays[parentIndex].times < arrays[index].times){
                    swap(parentIndex, index);
                    index = parentIndex;
                }else{
                    return;
                }
            }

        }

        public void swap(int index1, int index2){
            Node temp = arrays[index1];

            arrays[index1] = arrays[index2];

            arrays[index2] = temp;
        }

        public void heapify(int index, int end){
            int left = 2 * index + 1;
            while (left < end){
                int largest = left;
                if (left + 1 < end){
                    largest = arrays[left].times > arrays[left + 1].times? left : left + 1;
                }


                if (arrays[largest].times <= arrays[index].times){
                    break;
                }

                swap(largest, index);
                index = largest;
                left = 2 * index + 1;
            }
        }

        public int pop(){
            swap(0, size - 1);
            int ans = arrays[--size].val;
            heapify(0, size);
            return ans;
        }

    }

    public static void main(String[] args) {
        September19TopKFrequentElements fc = new September19TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        fc.topKFrequent(nums, 2);
    }
}
