package com.rock.node;

public class EntryOfCycle {
	
	/**
	 * 	��������л����ҵ�������ڵ�
	 *    	�Ѿ��߹��Ĳ��� : s (��ָ��)
	 *  		   	  2s(��ָ��)
	 *  	���ϵĽڵ�����: m
	 *  	�����ָ���ڻ���ת��nȦ������ͷ����ڵ�ľ���Ϊlh����ָ��Ϳ�ָ�������ĵ������ڵ�ľ���Ϊle,������ΪL
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
	
	// �ҵ�����ָ�ŵĽ����
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
