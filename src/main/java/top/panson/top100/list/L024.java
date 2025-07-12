package top.panson.top100.list;

import top.panson.top100.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-07-12
 */
public class L024 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }

            // 1 2 3 4 5
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            while(pre.next != null && pre.next.next != null) {
                ListNode p1 = pre.next;
                ListNode p2 = pre.next.next;

                p1.next = p2.next;
                p2.next = p1;
                pre.next = p2;

                pre = p1;

            }
            return dummy.next;
        }
    }
}
