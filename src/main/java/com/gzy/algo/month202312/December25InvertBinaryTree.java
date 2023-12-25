package com.gzy.algo.month202312;

import java.util.Stack;

public class December25InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {
        return process(root);
    }

    private TreeNode process(TreeNode node) {

        if (node == null){
            return null;
        }


        TreeNode left = process(node.left);

        TreeNode right = process(node.right);

        node.left = right;
        node.right = left;
        return node;
    }
}
