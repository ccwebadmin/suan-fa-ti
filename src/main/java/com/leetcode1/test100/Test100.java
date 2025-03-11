package com.leetcode1.test100;

import com.leetcode1.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 相同的树
 * @version  1.0
 * @Author cc
 * @Date 2025年03月08日 16:19
 */
public class Test100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(isSameTree(p, q));
        System.out.println(isSameTreeIterative(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        // 使用队列进行广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        //往队列中添加元素
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            //取出队列的头部元素
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();

            // 如果两个节点都为空，继续检查
            if (nodeP == null && nodeQ == null) {
                continue;
            }
            // 如果其中一个为空或值不相等，则树不同
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }

            // 将左右子节点按顺序加入队列
            queue.offer(nodeP.left);
            queue.offer(nodeQ.left);
            queue.offer(nodeP.right);
            queue.offer(nodeQ.right);
        }

        return true;
    }
}
