package com.example.variousdemo.entity;

/**
 * @className: ListNode
 * @description:
 * @created: 2021/08/31 13:59
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val ,ListNode next){
        this.val = val;
        this.next = next;
    }
}
