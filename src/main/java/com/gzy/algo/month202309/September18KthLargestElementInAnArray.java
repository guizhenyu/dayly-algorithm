package com.gzy.algo.month202309;

public class September18KthLargestElementInAnArray {


    /**
     * Given an integer array nums and an integer K, return the k-th largest elemetn in the array.
     * Note that it is the K-th largest element in the sorted order, not the K-th distinct element.
     * Can you solve it without sorting?
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public  int findKthLargest(int[] nums, int k) throws Exception {

        MyHead myHead = new MyHead(nums.length);
        for (int i = 0; i < nums.length; i++){
            myHead.push(nums[i]);
        }

        while (k - 1 > 0){
            myHead.pop();
            k--;
        }

        return myHead.pop();

    }


    class MyHead{


        int[] heap;

        int capacity;

        int size;

        public MyHead(int capacity){
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }


        public boolean push(int val){
            if (!isFull()){
                return false;
            }


            heap[size] = val;
            heapInsert(size++);
            return true;
        }

        public boolean isFull(){
           return size < capacity;
        }
        private void heapInsert(int index) {

            while (index > 0){

                int parentIndex = (index - 1) / 2;

                if (heap[parentIndex] < heap[index]){
                    swap(parentIndex, index);
                    index = parentIndex;
                }else {
                    return;
                }
            }
        }

        private void swap(int parentIndex, int index) {

            int temp = heap[parentIndex];
            heap[parentIndex] = heap[index];
            heap[index] = temp;

        }

        private int pop() throws Exception {
            if (size == 0){
                throw new Exception("堆中数据为空");
            }

            swap(0, size - 1);
            int ans = heap[--size];
            heapfy(0, size);
            return ans;
        }

        private void heapfy(int index, int size) {

            int left = 2 * index + 1;
            while (left < size){
                int largest = left;
                if (left + 1 < size){
                    largest = heap[left + 1] > heap[left]? left + 1 : left;
                }

                if (heap[index] > heap[largest]){
                    return;
                }

                swap(index, largest);

                index = largest;
                left = 2* index +1;

            }
        }


    }

    public static void main(String[] args) throws Exception {
        September18KthLargestElementInAnArray fc = new September18KthLargestElementInAnArray();
        int[] nums = {3,2,1,5,6,4};

        int kthLargest = fc.findKthLargest(nums, 2);
        System.out.println(kthLargest);

    }

}
