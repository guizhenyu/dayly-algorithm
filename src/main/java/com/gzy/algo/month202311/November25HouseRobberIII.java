package com.gzy.algo.month202311;

import java.util.HashMap;
import java.util.Map;

public class November25HouseRobberIII {

    public int rob(TreeNode root) {



        return process(root);
    }

    public int process(TreeNode node){
        if (node == null){

            return 0;
        }
        int p1 = node.val;
        if (node.left != null){
            p1 += process(node.left.left) + process(node.left.right);
        }
        if (node.right != null){
            p1 += process(node.right.left) + process(node.right.right);
        }
        int p2 = process(node.left) + process(node.right);
        return Math.max(p1, p2);
    }

    public int rob1(TreeNode root) {
        Map<TreeNode, Integer> cache = new HashMap<>();
        return process(root, cache);
    }

    public int process(TreeNode node, Map<TreeNode, Integer> cache){
        if (node == null){
            return 0;
        }

        if (cache.containsKey(node)){
            return cache.get(node);
        }
        int p1 = node.val;
        if (node.left != null){
            p1 += process(node.left.left, cache) + process(node.left.right, cache);
        }
        if (node.right != null){
            p1 += process(node.right.left, cache) + process(node.right.right, cache);
        }
        int p2 = process(node.left, cache) +process(node.right, cache);
        int ans = Math.max(p1, p2);
        cache.put(node, ans);
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
