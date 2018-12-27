package com.rock.node;

import java.util.ArrayList;

public class IsPalindrome {
	// 一遍遍历，用字符串记录
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ArrayList<Integer> nums = new ArrayList<>();
		while (head != null) {
			nums.add(head.val);
			head = head.next;
		}
		for (int i = 0 ; i < nums.size() / 2 ; i++) {
			int data1 = nums.get(i);
			int data2 = nums.get(nums.size() - i - 1);
			if (data1 != data2) {
				return false;
			}
					
		}
		return true;
    }
	
	// 将链表从1/2处反转，然后对比
	public boolean isPalindromeV2(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		int halfLength = len % 2 == 0 ? len / 2 : len / 2 + 1;
		tmp = head;
		int i = 0;
		while (i < halfLength && tmp != null) {
			tmp = tmp.next;
		}
		tmp = new ReverseList().reverseListV2(tmp);
		while (tmp != null) {
			if (head.val != tmp.val) {
				return false;
			}
			tmp = tmp.next;
			head = head.next;
		}
		return true;
	}
	
	public static void main(String [] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next = new ListNode(3);
		System.out.println(new IsPalindrome().isPalindromeV2(head));
	}
}
