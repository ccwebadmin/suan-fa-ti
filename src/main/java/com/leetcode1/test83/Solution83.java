package com.leetcode1.test83;


//        给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//        示例 1：
//
//
//        输入：head = [1,1,2]
//        输出：[1,2]
//        示例 2：
//
//
//        输入：head = [1,1,2,3,3]
//        输出：[1,2,3]
//        提示：
//
//        链表中节点数目在范围 [0, 300] 内
//        -100 <= Node.val <= 100
//        题目数据保证链表已经按升序 排列
public class Solution83 {
    public static void main(String[] args) {

        int[] arr = new int[]{1,1,2,2,3,3,4,555,555,666};
        Solution83 solution83 =new Solution83();
        ListNode head = solution83.deleteDuplicates(solution83.createLinkedList(arr));

        // 输出结果
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
