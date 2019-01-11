package com.rock.algorithm.tree;

import java.util.ArrayList;

public class TreeUtils {
	
	private static int index = 0;
	private ArrayList<Integer> treeElements;
	
	public TreeUtils(ArrayList<Integer> treeElements) {
		this.treeElements = treeElements;
	}
	
	public void reset() {
		index = 0;
	}
	
	// 先序递归创建二叉树
	public TreeNode createTree() {
		if (index < treeElements.size()) {
			int element = treeElements.get(index++);
			if (element != -1) {
				TreeNode node = new TreeNode(element);
				node.left = createTree();
				node.right = createTree();
				return node;
			} else {
				return null;
			}
		} else {
			return null;
		}
		
	}
	
	// 先序遍历二叉树
	public void preTravel(TreeNode root) {
		if (root != null) {
			int val = root.val;
			System.out.println(val);
			preTravel(root.left);
			preTravel(root.right);
		}
	}
	
	// 中序遍历
	public void midTravel(TreeNode root) {
		if (root != null) {
			midTravel(root.left);
			int val = root.val;
			System.out.println(val);
			midTravel(root.right);
		}
	}
	
	// 后序遍历
	public void backTravel(TreeNode root) {
		if (root != null) {
			backTravel(root.left);
			backTravel(root.right);
			int val = root.val;
			System.out.println(val);
			
		}
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
//		System.out.println(new MaxDepth().maxDepth(root));
	}
}
