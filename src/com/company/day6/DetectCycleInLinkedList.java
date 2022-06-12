package com.company.day6;

import com.company.utility.ListNode;

public class DetectCycleInLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
//        list.next.next.next = list.next;
        System.out.println(isCyclePresent(list));
    }

    private static boolean isCyclePresent(ListNode list) {
        ListNode fast = list.next;
        ListNode slow = list;
        while (fast!= null && fast.next != null) {
            if(fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
