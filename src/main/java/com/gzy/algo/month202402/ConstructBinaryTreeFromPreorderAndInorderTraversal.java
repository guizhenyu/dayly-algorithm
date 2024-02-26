package com.gzy.algo.month202402;

import com.gzy.algo.untils.TreeNode;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

       int n = preorder.length;

       indexMap = new HashMap<>();

       for (int i = 0; i < n; i++){
           indexMap.put(inorder[i], i);
       }


        return buildTreeProcess(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTreeProcess(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorder_left]);

        int inorder_root = indexMap.get(root.val);

        int left_length = inorder_root - inorder_left;

        root.left = buildTreeProcess(preorder, inorder, preorder_left + 1, preorder_left + left_length, inorder_left, inorder_root - 1);
        root.right = buildTreeProcess(preorder, inorder, preorder_left + left_length + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }


}
