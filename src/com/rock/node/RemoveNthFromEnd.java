package com.rock.node;

import java.util.ArrayList;

public class RemoveNthFromEnd {
	
	// 空间换时间
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode ret = head;
        while (head != null) {
        	nodes.add(head);
        	head = head.next;
        }
        int len = nodes.size();
        int start = len - n - 1;
        int target = len - n + 1;
        // 如果小于0，说明删除了头节点
        if (start < 0) {
        	ret = ret.next;
        	return ret;
        }
        if (target > len - 1) {
        	nodes.get(start).next = null;
        } else {
        	nodes.get(start).next = nodes.get(target);
        }
        return ret;
    }
	
	// 双指针法
	public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode first = head, second = head, ret = head;
        for (int j = 0 ; j < n && first != null ; j++) {
        	first = first.next;
        }
        // 删除了头节点
        if (first == null) {
        	ret = ret.next;
        	return ret;
        }
        while (first != null) {
        	second = second.next;
        	first = first.next;
        }
        second.next = second.next.next;
        return ret;
    }
	
	
	
	public static void main(String [] args) {
		ListNode head = new ListNode(3);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(4);
//		head.next.next.next = new ListNode(5);
//		head.next.next.next.next = new ListNode(7);
//		head.next.next.next.next.next = new ListNode(9);
//		head.next.next.next.next.next.next = new ListNode(10);
//		head.next.next.next.next.next.next.next = new ListNode(20);
		ListNode ret = new RemoveNthFromEnd().removeNthFromEndV2(head, 1);
		printListNodes(ret);
	}
	
	private static void printListNodes(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
			
		}
	}
}
