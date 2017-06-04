package com.wy.study.java.leetcode;

/**
 * Created by wy_ms on 2017/05/31.
 */
public class Minimum_Depth_of_Binary_Tree {

    public int minDepth(TreeNode root) {

        return depth(root,0);
    }

    int depth(TreeNode root, int depth) {
        if (root==null) {
            return depth;
        }
        depth++;
        int lefdep = depth(root.left,depth);
        int rightdep = depth(root.right,depth);
        return lefdep<rightdep?lefdep:rightdep;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
