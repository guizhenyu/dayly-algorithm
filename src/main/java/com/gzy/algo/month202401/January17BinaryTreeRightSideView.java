package com.gzy.algo.month202401;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class January17BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root){

        List<Integer> ans = new ArrayList<Integer>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() || !queue1.isEmpty()){

            if (!queue.isEmpty()){
                ans.add(processQueue(queue, queue1));
            }else {
                ans.add(processQueue(queue1, queue));
            }

        }


        return ans;
    }

    private Integer processQueue(Queue<TreeNode> queue, Queue<TreeNode> queue1) {
        Integer ans = null;
        TreeNode poll = queue.poll();
        ans = poll.val;
        offerNode(poll, queue1);

        while (!queue.isEmpty()){
            offerNode(queue.poll(), queue1);
        }
        return ans;

    }


    public void offerNode(TreeNode node, Queue<TreeNode> queue){
        if (node.right != null){
            queue.add(node.right);
        }

        if (node.left != null){
            queue.add(node.left);
        }
    }


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
}
