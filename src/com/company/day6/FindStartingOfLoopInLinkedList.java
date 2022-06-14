package com.company.day6;

import com.company.utility.ListNode;

public class FindStartingOfLoopInLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(3);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(10);
//        list.next.next.next.next.next.next.next = list.next.next.next.next;
        ListNode cycleNode = detectCycle(list);
        if(cycleNode == null) {
            System.out.println("no Cycle");
        } else {
            int pos = 0;
            while(list != cycleNode) {
                pos++;
                list = list.next;
            }
            System.out.println(pos);
        }
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}
