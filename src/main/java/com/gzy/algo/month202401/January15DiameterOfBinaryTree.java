package com.gzy.algo.month202401;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class January15DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        // 采用中序遍历
        Map<String, Integer> cache = new HashMap<String, Integer>();
        cache.put("max", 0);

        process(root, cache);

        return cache.get("max");
    }

    private int process(TreeNode root, Map<String, Integer> cache) {

        if (root == null){
            return 0;
        }

        int leftMaxDepth = process(root.left, cache);
        int rightMaxDepth = process(root.right, cache);

        int max = leftMaxDepth + rightMaxDepth;

        cache.put("max", Math.max(max, cache.get("max")));

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;

    }


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
}
