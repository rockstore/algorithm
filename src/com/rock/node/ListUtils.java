package com.rock.node;

public class ListUtils {
	
	public static void printListNodes(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
			
		}
	}
}
