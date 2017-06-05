package com.company;

import java.util.stream.IntStream;

public class addTwoNum {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode[] ls = s.createList(new int []{8,9,9},
                new int[]{2});
        s.showList(ls[0]);
        s.showList(ls[1]);
        ListNode l = s.addTwoNumbers(ls[0],ls[1]);
        s.showList(l);
    }
}



class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = l1;
        int overflow = 0;
        while (l1.next != null && l2.next != null){
            l1.val = l1.val + l2.val + overflow;
            overflow = l1.val/10;
            l1.val %= 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1.next == null && l2.next != null){
            l1.val = l1.val + l2.val + overflow;
            overflow = l1.val / 10;
            l1.val %= 10;
            l1.next = l2.next;
            l1 = l1.next;
            handleRemain(l1,overflow);
        }
        else if(l1.next != null && l2.next == null){
            l1.val = l1.val + l2.val + overflow;
            overflow = l1.val / 10;
            l1.val %= 10;
            l1 = l1.next;
            handleRemain(l1,overflow);
        }
        else if(l1.next == null && l2.next == null){
            l1.val = l1.val + l2.val + overflow;
            overflow = l1.val / 10;
            l1.val = l1.val % 10;
            if(overflow != 0){
                ListNode tail = new ListNode(overflow);
                l1.next = tail;
            }
        }

        return ans;
    }

    public void handleRemain(ListNode l, int overflow){
        while(l.next != null){
            l.val += overflow;
            overflow = l.val / 10;
            l.val %= 10;
            if(overflow == 0) break;
            l = l.next;
        }

        if(l.next == null){
            l.val += overflow;
            overflow = l.val/10;
            l.val %= 10;
            if(overflow != 0){
                ListNode tail = new ListNode(overflow);
                l.next = tail;
            }
        }
    }

    public ListNode[] createList(int[] l1, int[] l2){
        ListNode[] ls = new ListNode[2];
        ListNode tmp = null;

        for(int i = 0; i < l1.length; i++) {
            if (i == 0) {
                ls[0] = new ListNode(l1[0]);
                tmp = ls[0];
            }else {
                tmp.next = new ListNode((l1[i]));
                tmp = tmp.next;
            }
        }

        for(int i = 0; i < l2.length; i++) {
            if (i == 0) {
                ls[1] = new ListNode(l2[0]);
                tmp = ls[1];
            }else {
                tmp.next = new ListNode((l2[i]));
                tmp = tmp.next;
            }
        }

        return ls;
    }

    public void showList(ListNode l){
        while (l != null){
            System.out.print(l.val+" ");
            l = l.next;
        }
        System.out.println();
    }
}


class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){ this.val = x; }
}