package com.gzy.algo.month202403;

import com.gzy.algo.untils.TreeNode;

public class BinaryTreeMaximumPathSum {


    /**
     * A path in a binary tree is a sequence of nodes where each pair
     * of adjacent nodes in the sequence has an edge connecting them.
     * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
     * The path sum of a path is the sum of the node's values in the path.
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     * @param root
     * @return
     */

    int maxAns = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        backIterate(root);

        return maxAns;
    }

    public int backIterate(TreeNode node){
        if (node == null){
            return 0;
        }

        int val = node.val;

        int leftMax = backIterate(node.left);
        int rightMax = backIterate(node.right);
        int maxNode = Math.max(leftMax, rightMax);
        int max = val +  (leftMax > 0? leftMax : 0) + (rightMax > 0? rightMax : 0);

        maxAns = maxAns < max? max : maxAns;

        return val + (maxNode > 0? maxNode : 0);
    }
}
