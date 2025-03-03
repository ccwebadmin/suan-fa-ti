package com.leetcode1.test94;

import com.leetcode1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test94 {
    public static void main(String[] args) {
        // 创建一个示例二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);

        // 执行中序遍历
        List<Integer> res = inorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    //在递归方法里，return 语句是返回到上一层调用该递归函数的地方
    // 递归
    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        //下面的顺序就是遍历的顺序
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}
