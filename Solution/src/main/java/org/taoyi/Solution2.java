package org.taoyi;

public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode l3 = new ListNode();
        ListNode head  = l3;
        int flag = 0;
        while (l1!=null&&l2!=null) {
            l3.val = (l1.val + l2.val + flag)%10;
            flag = (l1.val + l2.val + flag)/10;
            l1 = l1.next;
            l2 = l2.next;
            if(l1!=null||l2!=null){
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }
        while (l1!=null){
            l3.val = (l1.val + flag)%10;
            flag = (l1.val + flag)/10;
            l1 = l1.next;
            if(l1!=null){
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }
        while (l2!=null){
            l3.val = (l2.val + flag)%10;
            flag = (l2.val + flag)/10;
            l2 = l2.next;
            if(l2!= null){
                l3.next = new ListNode();
                l3 = l3.next;
            }
        }
        if(flag!=0){
            l3.next = new ListNode();
            l3 = l3.next;
            l3.val = flag;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9);
        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
