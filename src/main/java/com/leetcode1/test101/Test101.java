package com.leetcode1.test101;

import com.leetcode1.TreeNode;


/**
 * @Description 判断对称二叉树
 * @Author cc
 * @Date 2025年03月10日 11:48
 */
public class Test101 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.left.right = new TreeNode(3);
        p.right= new TreeNode(2);
        p.right.left = new TreeNode(3);
        System.out.println(isSymmetric(p));
    }
    //判断root是否轴对称
    public static boolean isSymmetric(TreeNode root) {
        //判断root是否轴对称
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
