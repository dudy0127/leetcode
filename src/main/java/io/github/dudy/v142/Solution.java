package io.github.dudy.v142;

/**
 *
 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

 说明：不允许修改给定的链表。

 进阶：
 你是否可以不用额外空间解决此题？


 https://blog.csdn.net/wuzhekai1985/article/details/6725263


 找到相遇点后一个从 head走，一个从相遇点走，都是走一步，再次相遇就是 入口点
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
    public ListNode detectCycle(ListNode head) {


        if (head == null) return null;

        if(head.next == null || head.next.next == null) return null;


        ListNode preNode = head;
        ListNode curNode = head;
        ListNode enterCounter = null;

        while (curNode.next != null && curNode.next.next != null){

            preNode = preNode.next;
            curNode = curNode.next.next;

            if(preNode == curNode){
                enterCounter = preNode;
                break;
            }

        }


        if(enterCounter != null){

            preNode = head;
            while (preNode != enterCounter){
                preNode = preNode.next;
                enterCounter = enterCounter.next;
            }

            return preNode;
        }




        return enterCounter;
    }
}