package top.panson.top100.list;

import top.panson.top100.commondata.ListNode;

/**
 * @author Panson
 * @create 2025-07-12
 */
public class L002 {

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0); // 虚拟头
            ListNode curr = dummy;

            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                int val1 = (l1 != null ? l1.val : 0);
                int val2 = (l2 != null ? l2.val : 0);

                int sum = val1 + val2 + carry;
                carry = sum / 10;

                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            return dummy.next;
        }
    }

}
