package com.rock.node;

import java.util.ArrayList;

public class HasCycle {
	// o(1)空间复杂度，使用快慢指针
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode tmp = head;
		while (head != null && tmp != null) {
			head = head.next;
			if (tmp.next == null) {
				return false;
			}
			
			tmp = tmp.next.next;
			if (head == tmp) {
				return true;
			}
		}
		return false;
	}
	
	// o(n)空间复杂度
	public boolean hasCycleV2(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ArrayList<Integer> datas = new ArrayList<>();
		while (head != null) {
			if (datas.contains(head.val)) {
				return true;
			} else {
				datas.add(head.val);
				head = head.next;
			}
		}
		return false;
	}
	
	// 距离头结点的距离变化
	public boolean hasCycleV3(ListNode head) {
		int max = 0;
		int cur = 0;
		ListNode tmp = head;
		while (tmp != null) {
			cur = distanceFromHead(head, tmp);
			if (cur >= max) {
				max = cur;
			} else {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	private int distanceFromHead(ListNode head, ListNode cur) {
		ListNode tmp = head;
		int distance = 0;
		while (tmp != cur) {
			distance++;
			tmp = tmp.next;
		}
		return distance;
	}
	
	public static void main(String [] args) {
		ListNode head = new ListNode(3);
		ListNode l1 = new ListNode(2);
		head.next = l1;
		ListNode l2 = new ListNode(4);
		head.next.next = l2;
		ListNode l3 = new ListNode(5);
		head.next.next.next = l3;
		head.next.next.next.next = head;
		System.out.println(new HasCycle().hasCycle(head));
	}
}
