package com.company.day7;

import com.company.utility.ListNode;

public class RotateALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(9);
        int k = 3;
        ListNode res = shiftLeft(head, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static ListNode rotate(ListNode head, int k) {
        ListNode fast = head;
        for(int i=0; i<k; ++i) {
            fast = fast.next;
        }
        if(fast == null) {
            return head;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        fast.next = head;
        head = temp;
        return head;
    }

    private static ListNode shiftLeft(ListNode head, int k) {
        ListNode fast = head;
        ListNode prev = head;
        for(int i=0; i<k; ++i) {
            prev = fast;
            fast = fast.next;
        }
        if(fast == null) {
            return head;
        }
        ListNode tmpFast = fast;
        while(fast.next != null) {
            fast = fast.next;
        }
        fast.next = head;
        head = tmpFast;
        prev.next = null;
        return head;
    }
}
