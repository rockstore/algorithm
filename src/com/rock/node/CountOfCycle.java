package com.rock.node;

public class CountOfCycle {
	/**
	 *	链表有环，计算环上节点的数量
	 *	由于已经计算出环的入口点-可以使用一次循环便可计算环的长度，可以从入口点循环，也可以从交汇点开始循环
	 *
	 *	如果已经知道链表的长度L，可以直接用L减去链表头到入口点之间的距离
	 * */
	public int countOfCycle(ListNode head) {
		ListNode tmp = head;
		ListNode crossPoint = new EntryOfCycle().crossPoint(tmp);
		return getLengthOfCycle(crossPoint);
	}
	
	public int countOfCycleV2(ListNode head) {
		ListNode tmp = head;
		ListNode entry = new EntryOfCycle().entryOfCycle(tmp);
		return getLengthOfCycle(entry);
	}
	
	private int getLengthOfCycle(ListNode entry) {
		if (entry == null) {
			return 0;
		}
		ListNode tmpCross = entry.next;
		int count = 1;
		while (tmpCross != entry) {
			tmpCross = tmpCross.next;
			count++;
		}
		return count;
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
		System.out.println(new CountOfCycle().countOfCycle(head));
	}
}
