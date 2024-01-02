package com.gzy.algo.month202312;

import java.util.*;

public class December28BalanceBinarySearchTree {


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

    List<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root){
        if (root == null){
            return null;
        }
        midIteration(root);

        return build(0, list.size() - 1);


    }

    private TreeNode build(int l, int r) {
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(list.get(mid).val);

        if (l + 1 <= mid){
            node.left = build(l, mid - 1);
        }

        if (r - 1 >= mid){
            node.right = build(mid + 1, r);
        }

        return node;
    }

    public void midIteration(TreeNode node){

        if (node.left != null){
            midIteration(node.left);
        }

        list.add(node);

        if (node.right != null){
            midIteration(node.right);
        }

    }


}
