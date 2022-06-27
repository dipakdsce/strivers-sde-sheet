package com.company.day6;

import com.company.utility.ListNode;
import com.company.utility.ListNodeMod;

public class FlatteningOfLinkedList {
    public static void main(String[] args) {
        ListNodeMod head = new ListNodeMod(5);
        head.next = new ListNodeMod(10);
        head.next.next = new ListNodeMod(19);
        head.next.next.next = new ListNodeMod(28);
        head.bottom = new ListNodeMod(7);
        head.bottom.bottom = new ListNodeMod(8);
        head.bottom.bottom.bottom = new ListNodeMod(30);
        head.next.bottom = new ListNodeMod(20);
        head.next.next.bottom = new ListNodeMod(22);
        head.next.next.bottom.bottom = new ListNodeMod(50);
        head.next.next.next.bottom = new ListNodeMod(35);
        head.next.next.next.bottom.bottom = new ListNodeMod(40);
        head.next.next.next.bottom.bottom.bottom = new ListNodeMod(45);
        ListNodeMod resHead = doFlattening(head);
        while (resHead != null) {
            System.out.print(resHead.val + " ");
            resHead = resHead.bottom;
        }
    }

    private static ListNodeMod doFlattening(ListNodeMod head) {
        if(head == null || head.next == null) {
            return head;
        }
        head.next = doFlattening(head.next);

        head = mergeTwoList(head, head.next);
        return head;
    }

    private static ListNodeMod mergeTwoList(ListNodeMod a, ListNodeMod b) {
        ListNodeMod temp = new ListNodeMod(0);
        ListNodeMod res = temp;

        while(a != null && b != null) {
            if(a.val < b.val) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if(a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }

        return res.bottom;
    }
}
