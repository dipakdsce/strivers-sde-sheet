package com.company.day5;

import com.company.utility.ListNode;

public class DeleteGivenNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        ListNode node = new ListNode(2);
        listNode.next.next = node;
        listNode.next.next.next = new ListNode(3);
        delete(node);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    private static void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
