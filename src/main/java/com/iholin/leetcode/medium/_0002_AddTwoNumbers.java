package com.iholin.leetcode.medium;

import java.util.LinkedList;

public class _0002_AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static void main(String[] args) {
        _0002_AddTwoNumbers solution = new _0002_AddTwoNumbers();

        // Создаем первый список: 2 -> 4 -> 3 (число 342)
        ListNode l1 = solution.new ListNode(2);
        l1.next = solution.new ListNode(4);
        l1.next.next = solution.new ListNode(3);

        // Создаем второй список: 5 -> 6 -> 4 (число 465)
        ListNode l2 = solution.new ListNode(5);
        l2.next = solution.new ListNode(6);
        l2.next.next = solution.new ListNode(4);

        // Вызываем метод
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Выводим результат в консоль
        while (result != null) {
            System.out.print(result.val + (result.next != null ? " -> " : ""));
            result = result.next;
        }
    }
}
