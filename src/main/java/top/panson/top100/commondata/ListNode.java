package top.panson.top100.commondata;


/**
 * @create 2022-01-14 00:04
 * @Author: Panson
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
