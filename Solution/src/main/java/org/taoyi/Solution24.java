package org.taoyi;

public class Solution24 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode tmp = head.next.next;;
        ListNode tmp2;
        if(head!=null&&head.next!=null){
            tmp2 = head;
            head = head.next;
            head.next = tmp2;
        }
        head.next.next = swapPairs(tmp);
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new Solution24().new ListNode(1);
        ListNode node2 = new Solution24().new ListNode(2);
        ListNode node3 = new Solution24().new ListNode(3);
        ListNode node4 = new Solution24().new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        new Solution24().swapPairs(node1);
    }
}
