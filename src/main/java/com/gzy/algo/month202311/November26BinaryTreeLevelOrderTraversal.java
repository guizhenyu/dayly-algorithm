package com.gzy.algo.month202311;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class November26BinaryTreeLevelOrderTraversal {

    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<TreeNode> stackEveryLevel = new Stack<>();
        while (!stack.isEmpty()){
            stackEveryLevel.push(stack.pop());
            if (stack.isEmpty()){
                List<Integer> nodes = new ArrayList<>();
                while (!stackEveryLevel.isEmpty()){
                    TreeNode pop = stackEveryLevel.pop();
                    if (pop.left != null){
                        stack.push(pop.left);
                    }
                    if (pop.right != null){
                        stack.push(pop.right);
                    }

                    nodes.add(pop.val);
                }
                ans.add(nodes);
            }
        }
        return ans;
    }
}
