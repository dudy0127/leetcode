package io.github.dudy.leecode.v141;

/**

 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 TODO:环的长度
 TODO:环的入口

 解题思路:
 1.双指针
 2.Hash表判断是否存在，时间复杂度0(n)

 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {


        if(head == null) return false;

        if(head.next == null || head.next.next == null) return false;

        ListNode preNode = head;
        ListNode curNode = head;

        while (curNode.next != null && curNode.next.next != null){
            preNode = preNode.next;
            curNode = curNode.next.next;
            if(preNode == curNode){
                return true;
            }
        }
        return false;
    }
}