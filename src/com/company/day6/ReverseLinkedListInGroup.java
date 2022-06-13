package com.company.day6;

import com.company.utility.ListNode;

public class ReverseLinkedListInGroup {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next = new ListNode(8);
//        ListNode res = reverseInGroup(list, 3);
        ListNode res = reverseInGroupGFG(list, 3);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static ListNode reverseInGroup(ListNode head, int k) {
        if(head ==  null || head.next == null) {
            return head;
        }
        int length = length(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr , next;
        while (length >= k) {
            curr = prev.next;
            next = curr.next;
            for(int i=1; i<k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummy.next;
    }

    private static ListNode reverseInGroupGFG(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null) {
            head.next = reverseInGroupGFG(next, k);
        }
        return prev;
    }

    private static int length(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
