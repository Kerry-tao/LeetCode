package org.taoyi;

public class Solution21 {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null&&list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode i = list1;
        ListNode j = list2;
        ListNode newhead;

        if(i.val<j.val){
            newhead = i;
            i = i.next;
        }else{
            newhead = j;
            j = j.next;
        }
        ListNode current = newhead;
        while(i!=null&&j!=null){
            if(i.val<j.val){
                current.next = i;
                current = current.next;
                i = i.next;
            }else{
                current.next = j;
                current = current.next;
                j = j.next;
            }
        }
        if(i!=null) current.next = i;
        if(j!=null) current.next = j;
        return newhead;
    }

    public static void main(String[] args) {
        ListNode node1 = new Solution21().new ListNode(-9);
        ListNode node2 = new Solution21().new ListNode(3);
        ListNode node3 = new Solution21().new ListNode(5);
        ListNode node4 = new Solution21().new ListNode(7);
        node1.next = node2;
        node3.next = node4;
        ListNode newNode = new Solution21().mergeTwoLists(node1,node3);
        while (newNode.next !=null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }
}
