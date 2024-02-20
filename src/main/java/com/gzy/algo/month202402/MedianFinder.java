package com.gzy.algo.month202402;

import java.util.PriorityQueue;

public class MedianFinder {
        // 大根堆
        PriorityQueue<Integer> minQueue;
        // 小根堆
        PriorityQueue<Integer> maxQueue;

        public MedianFinder() {
                minQueue = new PriorityQueue<>((a, b) -> b - a);
                maxQueue = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num){
                if (minQueue.isEmpty() || num < minQueue.peek()){
                        minQueue.add(num);
                        if (maxQueue.size() + 1 < minQueue.size()){
                                maxQueue.add(minQueue.poll());
                        }
                }else {
                        maxQueue.add(num);
                        if (maxQueue.size() > minQueue.size()){
                                minQueue.add(maxQueue.poll());
                        }
                }
        }


        public double findMedian(){
                if (maxQueue.size() != minQueue.size()){
                        return minQueue.peek();
                }else {
                        return (minQueue.peek() + maxQueue.peek()) / 2.0;
                }
        }

}


