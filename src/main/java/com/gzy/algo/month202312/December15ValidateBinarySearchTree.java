package com.gzy.algo.month202312;


public class December15ValidateBinarySearchTree {

/**
 * Definition for a binary tree node.
 * */
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidNode(TreeNode node, long maxValue, long minValue){
        if (node == null){
            return true;
        }

        if (node.val <= minValue || node.val >= maxValue){
            return false;
        }

        return isValidNode(node.left, node.val, minValue) && isValidNode(node.right, maxValue, node.val);
    }
}
