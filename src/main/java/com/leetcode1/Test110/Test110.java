package com.leetcode1.Test110;

import com.leetcode1.TreeNode;

/**
 * @Description 判断一个树是否是平衡二叉树
 * 什么是平衡二叉树
 *    => 左右子树高度差不超过1（各个节点的左右子树递归概念）
 * @Author cc
 * @Date 2025年03月18日 18:40
 */
public class Test110 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.right = new TreeNode(3);
        p.right= new TreeNode(2);
        p.right.left = new TreeNode(3);
        System.out.println(isBalanced(p));
    }
    //判断是否是平衡二叉树
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
