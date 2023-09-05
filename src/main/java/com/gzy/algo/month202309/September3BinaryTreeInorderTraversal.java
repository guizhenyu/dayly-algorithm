package com.gzy.algo.month202309;

import java.util.ArrayList;
import java.util.List;

public class September3BinaryTreeInorderTraversal {

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     */

    public List<Integer> inorderTraversal(TreeNode root){

        List<Integer> ans = new ArrayList<Integer>();
        travel(root, ans);
        return ans;
    }

    private void travel(TreeNode root, List<Integer> ans) {

        if (root == null){
            return;
        }
        if (root.left != null){
            travel(root.left, ans);
        }
        ans.add(root.val);

        if (root.right != null){
            travel(root.right, ans);
        }

    }

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
}
