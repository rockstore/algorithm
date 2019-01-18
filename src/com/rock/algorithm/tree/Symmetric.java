package com.rock.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Symmetric {
	
	// 二叉树是否对称，递归实现
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
	
    // 二叉树是否对象，顺序实现，使用两个栈
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if(root.left == null || root.right == null) {
        	return false;
        } 
        LinkedList<TreeNode> deque = new LinkedList<>();

        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        
        while(!deque.isEmpty()) {
            TreeNode head = deque.pollFirst();
            TreeNode tail = deque.pollLast();
            if(head.val != tail.val) {
            	return false;
            }
            if ((head.left == null && tail.right != null) || (head.left != null && tail.right == null)) {
            	return false;
            }
            if (head.left != null) {
                deque.offerFirst(head.left);
                deque.offerLast(tail.right);
            }
            if ((head.right == null && tail.left != null) || (head.right != null && tail.left == null)) {
            	return false;
            }
            if(head.right != null) {
                deque.offerFirst(head.right);
                deque.offerLast(tail.left);
            }
        }
        return true;
    }
	
    public static void main(String [] args) {
		/**
		 * create a tree like this:
		 * 				1
		 * 			   / \
		 * 			  2   3
		 * 				 /
		 * 				4
		 * */
		ArrayList<Integer> elements = new ArrayList<>();
		elements.add(1);
		elements.add(2);
		elements.add(-1);
		elements.add(-1);
		elements.add(3);
		elements.add(4);
		elements.add(-1);
		
		TreeUtils utils = new TreeUtils(elements);
		TreeNode root = utils.createTree();
		utils.backTravel(root);
		utils.reset();
		System.out.println(new Symmetric().isSymmetric(root));
	}
}
