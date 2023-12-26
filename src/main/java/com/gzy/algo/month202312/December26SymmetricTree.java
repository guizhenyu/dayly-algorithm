package com.gzy.algo.month202312;

import java.util.LinkedList;
import java.util.Queue;

public class December26SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (!compareNode(root.left, root.right, queue)){
            return false;
        }
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (!compareNode(left.left, right.right, queue)){
                return false;
            }
            if (!compareNode(left.right, right.left, queue)){
                return false;
            }
        }

        return true;
    }


    public boolean compareNode(TreeNode left, TreeNode right, Queue<TreeNode> queue){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }
        queue.add(left);
        queue.add(right);
        return true;
    }
}
