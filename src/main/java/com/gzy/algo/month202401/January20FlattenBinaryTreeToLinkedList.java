package com.gzy.algo.month202401;

import com.gzy.algo.untils.TreeNode;

public class January20FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {


        process(root);
    }

    public TreeNode process(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        TreeNode tail = null;
        TreeNode next = node;
        if (left != null) {
            next.right = left;
            tail = process(left);
        }
        if (tail != null){
            next = tail;
        }

        if (right != null) {
            next.right = right;
            tail = process(right);
        }

        return tail;
    }
}
