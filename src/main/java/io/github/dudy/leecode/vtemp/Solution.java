package io.github.dudy.leecode.vtemp;


/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) {
            return head;
        }

        // 找到开始的节点
        int i ;
        ListNode newHead = null;
        ListNode startNode = null;

        for (i = 0; i < m; i++) {
            startNode = head.next;
        }

        ListNode tempStartNode = startNode;

        // 从开始节点反转,反转出新的链表
        while (startNode.next != null && i< n){

            ListNode temp = startNode.next;

            startNode.next = newHead;

            newHead = startNode;

            startNode = temp;
            i++;
        }


        // 用中间这段替换掉



        return head;
    }
}