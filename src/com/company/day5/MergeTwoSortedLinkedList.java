package com.company.day5;

import com.company.utility.ListNode;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(7);
        list1.next.next = new ListNode(10);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(10);
        ListNode mergedList = mergeList(list1, list2);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }

    private static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode res = null;
        ListNode head = null;
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                if(res == null) {
                    res = list1;
                    head = res;
                } else {
                    res.next = list1;
                    res = res.next;
                }
                list1 = list1.next;
            } else {
                if(res == null) {
                    res = list2;
                    head = res;
                } else {
                    res.next = list2;
                    res = res.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 != null) {
            res.next = list1;
        }

        if(list2 != null) {
            res.next = list2;
        }
        return head;
    }
}
