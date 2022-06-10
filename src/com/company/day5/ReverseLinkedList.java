package com.company.day5;

import com.company.utility.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(10);
        ListNode res = reverseRecursive(listNode);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null, next = null;
        while(node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private static ListNode reverseRecursive(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        ListNode nNode = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return nNode;
    }
}
