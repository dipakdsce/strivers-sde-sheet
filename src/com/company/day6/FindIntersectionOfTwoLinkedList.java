package com.company.day6;

import com.company.utility.ListNode;

import java.util.HashSet;

public class FindIntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(1);

        ListNode list2 = new ListNode(3);

        ListNode commonList = new ListNode(2);
        commonList.next = new ListNode(4);
        list2.next = commonList;
        list1.next.next.next = commonList;
        ListNode res;
        System.out.println((res = findIntersectionNode(list1, list2)) == null ? null : res.val);
        System.out.println(findIntersectionPoint(list1, list2));
    }

    public static ListNode findIntersectionNode(ListNode list1, ListNode list2) {
        HashSet<ListNode> set = new HashSet<>();
        while (list1 != null) {
            set.add(list1);
            list1 = list1.next;
        }

        while (list2 != null) {
            if (set.contains(list2)) {
                return list2;
            }
            list2 = list2.next;
        }
        return null;
    }

    //Without extra space
    private static int findIntersectionPoint(ListNode head1, ListNode head2) {
        if (head1 == null && head2 != null) return -1;
        ListNode a = head1, b = head2;
        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }
        return a == null ? -1 : a.val;
    }
}
