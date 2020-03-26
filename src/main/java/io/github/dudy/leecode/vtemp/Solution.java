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
 *
 *
 *
 * 重要的是记录 m和n节点
 *
 *
 *
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

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode mPre=dummy,nNext=null,curr=null,next=null,prev=null;


        // 查找m点的前节点
        for(int i=0;i<m-1;i++){
            mPre=mPre.next;
        }
        curr=mPre.next; // 当前节点
        for(int i=0;i<=n-m;i++){
            next=curr.next; // 下一个节点
            curr.next=prev; //
            prev=curr;
            curr=next;
            nNext=next;
        }
        mPre.next.next=nNext;
        mPre.next=prev;
        return dummy.next;
    }
}