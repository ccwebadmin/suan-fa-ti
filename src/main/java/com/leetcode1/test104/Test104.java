package com.leetcode1.test104;

import com.leetcode1.TreeNode;

/**
 * @Description 计算树的度
 * @Author cc
 * @Date 2025年03月13日 18:35
 */
public class Test104 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.right = new TreeNode(3);
        p.right= new TreeNode(2);
        p.right.left = new TreeNode(3);
        System.out.println(maxDepth(p));
    }
    // 递归求解
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
