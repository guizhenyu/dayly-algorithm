package com.gzy.algo.month202402;

import com.gzy.algo.untils.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {


    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia: " The lowest common ancestor is defined between two nodes p and q
     * as the lowest node in T that has both p and q as descendants(where we allow a node to be a descendant of itself)"
     * @param root
     * @param p
     * @param q
     * @return
     */
    Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        dfs(root);
        if (p != null){
            visited.add(p.val);
            p = map.get(p.val);
        }


        if (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }

            q = map.get(q.val);
        }

        return null;

    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }

        map.put(root.val, root);

        if (root.left != null){
            dfs(root.left);
        }

        if (root.right != null){
            dfs(root.right);
        }
    }


}
