package com.leetcode1.test206;

/**
 * 链表反转
 */
public class Solution {

    public static void main(String[] args) {
        // 创建一个链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        // 反转链表
        ListNode reversedHead = new Solution().reverseList(head);

        // 打印反转后的链表
        System.out.println(reversedHead.val); // 3
        System.out.println(reversedHead.next.val); // 2
        System.out.println(reversedHead.next.next.val); // 1
    }

    public ListNode reverseList(ListNode head) {
        // 定义两个指针，分别指向前一个节点和当前节点。
        ListNode prev = null;
        ListNode currNode = head;

        // 遍历链表，并将每个节点的 next 指针指向前一个节点。
        while (currNode != null) {
            // 保存当前节点的下一个节点。
            ListNode next = currNode.next;

            // 将当前节点的 next 指针指向前一个节点。
            currNode.next = prev;

            // 更新前一个节点。
            prev = currNode;

            // 更新当前节点。
            currNode = next;
        }

        return prev;
    }

}
