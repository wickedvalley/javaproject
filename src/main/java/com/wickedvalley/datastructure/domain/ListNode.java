package com.wickedvalley.datastructure.domain;

/**
 * Created by Administrator on 2018/7/7.
 */
public class ListNode {

    private Integer value;

    private ListNode next;

    public ListNode(Integer value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode(Integer value) {
        this.value = value;
    }

    public ListNode() {
    }
}
