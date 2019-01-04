package com.rock.node;

public class CountOfCycle {
	/**
	 *	�����л������㻷�Ͻڵ������
	 *	�����Ѿ������������ڵ�-����ʹ��һ��ѭ����ɼ��㻷�ĳ��ȣ����Դ���ڵ�ѭ����Ҳ���Դӽ���㿪ʼѭ��
	 *
	 *	����Ѿ�֪������ĳ���L������ֱ����L��ȥ����ͷ����ڵ�֮��ľ���
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
