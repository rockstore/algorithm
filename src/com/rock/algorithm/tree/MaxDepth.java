package com.rock.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxDepth {
	
	// �ݹ���������������
	public int maxDepth(TreeNode root) {
		int depth = 0;
        if (root != null) {
            depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return depth;
    }

	/**
	 * ˳�����������������ȣ�ʹ�÷ֲ����
	 * */
	public int maxDepthV2(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ++depth;
            for (int i = queue.size(); i > 0; --i) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                	queue.offer(t.left);
                }
                if (t.right != null) {
                	queue.offer(t.right);
                }
            }
        }
        return depth;
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
		utils.reset();
		System.out.println(new MaxDepth().maxDepthV2(root));
	}
}
