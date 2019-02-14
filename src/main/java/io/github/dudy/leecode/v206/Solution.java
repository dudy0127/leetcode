package io.github.dudy.leecode.v206;

/**
 * 反转一个单链表。
 示例:
 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 思路：新建一个空间链表，倒序执行

 https://blog.csdn.net/fx677588/article/details/72357389
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {


        if(head == null || head.next == null) return head;

        ListNode p = head;
        ListNode newH = null; // 新的空间列表
        while (p != null){

            ListNode temp = p.next;// 临时变量存储下一个节点
            p.next = newH; // 当前节点指向新的空间链表
            newH = p; // 新空间链表指向当前节点
            p = temp; // 当前节点指向下一个节点
        }

        return newH;
    }
}