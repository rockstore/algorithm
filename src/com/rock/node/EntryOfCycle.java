package com.rock.node;

public class EntryOfCycle {
	
	/**
	 * 	如果链表有环，找到环的入口点
	 *    	已经走过的步数 : s (慢指针)
	 *  		   	  2s(快指针)
	 *  	环上的节点数量: m
	 *  	假设快指针在环内转了n圈，链表头到入口点的距离为lh，慢指针和快指针相遇的点距离入口点的距离为le,链表长度为L
	 *  	
	 *  	2s = s + m * n
	 *  	s  = m * n
	 *  	lh + le = s = m *n = (n - 1) * m + m = (n - 1) * m + (L - lh)
	 *  	lh + le = (n - 1) * m + (L - lh)
	 *  	lh = (n - 1) * m + (L - lh - le) => lh = m * n - le => lh = m - le	
	 * */
	public ListNode entryOfCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		} else {
			ListNode tmp = head;
			ListNode cross = crossPoint(tmp);
			while (head != null && cross != null) {
				if (head == cross) {
					return head;
				} else {
					head = head.next;
					cross = cross.next;
				}
			}
		}
		return null;
	}
	
	// 找到快慢指着的交汇点
	public ListNode crossPoint(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode tmp = head;
		while (head != null && tmp != null) {
			head = head.next;
			if (tmp.next == null) {
				return null;
			}
			
			tmp = tmp.next.next;
			if (head == tmp) {
				return head;
			}
		}
		return null;
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
		ListNode entry = new EntryOfCycle().entryOfCycle(head);
		System.out.println(entry.val);
	}
}
