package com.leetcode1.test94;

import com.leetcode1.TreeNode;

import java.util.Stack;

public class example {


    public static void main(String[] args) {
        // 创建一个示例二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);

        // 执行中序遍历
        inorderTraversalIterative(root);
    }

    public static void inorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 达到最左边的节点
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 弹出栈顶元素并访问
            current = stack.pop();
            System.out.print(current.val + " ");

            // 移动到右子树
            current = current.right;
        }
    }
}

