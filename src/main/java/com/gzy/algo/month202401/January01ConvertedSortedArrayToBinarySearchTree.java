package com.gzy.algo.month202401;

public class January01ConvertedSortedArrayToBinarySearchTree {

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


    public TreeNode sortedArrayToBST(int[] nums){
        return build(nums, 0, nums.length - 1);
    }


    public TreeNode build(int[] nums, int l, int r){
        int mid = (l + r) >> 1;

        TreeNode node = new TreeNode(nums[mid]);

        if (l < mid){
            node.left = build(nums, l, mid - 1);
        }

        if (r > mid){
            node.right = build(nums, mid + 1, r);
        }

        return node;

    }
}
