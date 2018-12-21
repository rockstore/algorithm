package com.rock.node;

import java.util.ArrayList;


public class ReverseList {
	
	// 空间换时间
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
			nodes.add(head);
			head = head.next;
		}
        int size = nodes.size();
        for (int i = size - 1 ; i > 0 ; i--) {
        	nodes.get(i).next = nodes.get(i - 1);
        }
        nodes.get(0).next = null;
        return nodes.get(size - 1);
    }
	
	// 原地反转
	public ListNode reverseListV2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode pre = head;
		head = head.next;
		while (head != null) {
			pre.next = head.next;
			head.next = dummyNode.next;
			dummyNode.next = head;
			head = pre.next;
		}
		return dummyNode.next;
    }
	
	// 新建链表，头结点插入法
	public ListNode reverseListV3(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummyNode = new ListNode(-1);
		while (head != null) {
			ListNode node = new ListNode(head.val);
			node.next = dummyNode.next;
			dummyNode.next = node;
			head = head.next;
		}
        return dummyNode.next;
    }
	
	public static void main(String [] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next.next.next = new ListNode(20);
		ListNode ret = new ReverseList().reverseListV2(head);
		ListUtils.printListNodes(ret);
	}
	
	
}
