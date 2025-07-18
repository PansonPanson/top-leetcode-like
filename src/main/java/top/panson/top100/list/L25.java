package top.panson.top100.list;

import top.panson.top100.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-07-13
 */
public class L25 {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            while(head != null) {
                ListNode tail = pre;
                for(int i = 0; i < k; i++) {
                    tail = tail.next;
                    if(tail == null) {
                        return dummy.next;
                    }
                }
                ListNode next = tail.next;
                ListNode[] sub = reverseSub(head, tail);
                head = sub[0];
                tail = sub[1];
                pre.next = head;
                tail.next = next;
                pre = tail;
                head = tail.next;
            }
            return dummy.next;
        }

        public ListNode[] reverseSub(ListNode head, ListNode tail) {
            ListNode pre = tail.next;
            ListNode cur = head;
            while(pre != tail) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return new ListNode[]{tail, head};
        }
    }
}
