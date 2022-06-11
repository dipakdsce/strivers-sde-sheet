package com.company.day5;

import com.company.utility.ListNode;

public class AddTwoNumberAsList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        ListNode sum = sum(list1, list2);
        while (sum != null) {
            System.out.print(sum.val + " ");
            sum = sum.next;
        }
    }

    private static ListNode sum(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }
        int carry = 0;
        ListNode res = new ListNode();
        ListNode dummy = res;
        while(list1 != null || list2 != null || carry == 1) {
            int sum = 0;
            if(list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if(list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            sum += carry;
            carry = sum/10;
            res.next = new ListNode(sum % 10);
            res = res.next;
        }
        return dummy.next;
    }
}
