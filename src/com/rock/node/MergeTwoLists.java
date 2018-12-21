package com.rock.node;

public class MergeTwoLists {
	// 原地合并，不需要申请新的空间
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        }
        if (l2 == null) {
        	return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
            	tmp.next = l1;
                l1 = l1.next;
            } else {
            	tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 == null) {
        	tmp.next = l2;
        }
        if (l2 == null) {
        	tmp.next = l1;
        }
        return head;
    }
    
    // 新建链表合并
    
    
    public static void main(String [] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);
		l2.next.next.next = new ListNode(6);
		ListNode merge = new MergeTwoLists().mergeTwoLists(l1, l2);
		ListUtils.printListNodes(merge);
	}
}
