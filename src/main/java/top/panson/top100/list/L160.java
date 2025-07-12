package top.panson.top100.list;

import top.panson.top100.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-07-12
 */
public class L160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA;
            ListNode p2 = headB;

            while(p1 != p2) {
                if(p1 == null) {
                    p1 = headB;
                } else {
                    p1 = p1.next;
                }
                if(p2 == null){
                    p2 = headA;
                } else {
                    p2 = p2.next;
                }
            }
            return p1;
        }
    }
}
