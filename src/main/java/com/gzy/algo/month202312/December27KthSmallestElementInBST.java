package com.gzy.algo.month202312;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class December27KthSmallestElementInBST {



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

    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode leftNode = root.left;
        while (leftNode != null){
            stack.push(leftNode);
            leftNode = leftNode.left;
        }



        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(--k == 0){
                return pop.val;
            }
            TreeNode right = pop.right;
            while (right != null){
                stack.push(right);
                right = right.left;
            }
        }

        return -1;
    }


}
