package edu.helen.leetcode;

public class AddTwoNumber {

    public AddTwoNumber() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head1 = res;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + carry;
            if (temp >= 10) {
                temp = temp % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(temp);
            res.next = node;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                ListNode one = new ListNode(1);
                res.next = one;
            }
            return head1.next;
        }
        ListNode tail = l1 == null ? l2 : l1;
        ListNode head2 = tail;
        if (carry == 1) {
            while (carry == 1 && tail != null) {
                int temp = tail.val + 1;
                if (temp >= 10) {
                    temp = temp % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(temp);
                res.next = node;
                res = res.next;
                tail = tail.next;
            }
            if(carry==1){
                ListNode node = new ListNode(1);
                res.next = node;
            }else{
                res.next = tail;
            }
        } else {
            res.next = tail;
        }
        return head1.next;

    }

}
