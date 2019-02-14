package io.github.dudy.leecode.v19;

/**
 *
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

/**
 * 解题思路:
 * 双指针解法(前指针，后指针)，先让前指针走n个步，再让两个在指针同时后移，直到前指针到达尾部，此时，后指针的下一个节点就是要被删除的节点了。
 *
 */
public  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode preNode = head;
        ListNode curNode = head;

        for (int i = 0;i<n;i++){
            curNode = curNode.next;
        }

        if(curNode == null){
            return preNode.next;
        }


        while (curNode.next != null){
            curNode = curNode.next;
            preNode = preNode.next;
        }

        preNode.next = preNode.next.next;

        return head;
    }
}