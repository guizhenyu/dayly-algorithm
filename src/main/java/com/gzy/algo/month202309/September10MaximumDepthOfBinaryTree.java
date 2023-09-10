package com.gzy.algo.month202309;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class September10MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root){


        return process(root, 0);

    }

    private int process(TreeNode node, int depth) {
        if (node == null){
            return depth;
        }

        int leftDepth = process(node.left, depth + 1);

        int rightDepth = process(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    private int processBFS(TreeNode node, int depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        if (node != null){
            queue.add(node);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
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
