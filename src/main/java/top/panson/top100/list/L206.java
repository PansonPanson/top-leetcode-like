package top.panson.top100.list;

import top.panson.top100.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-07-12
 */
public class L206 {
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
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            ListNode next;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
