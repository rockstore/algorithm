package com.rock.algorithm.tree;

public class SortedArrayToBST {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null) {
			return null;
		}
		return build(nums, 0, nums.length - 1);
    }
	
	
	public TreeNode build(int [] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (end + start) / 2;
		TreeNode root = new TreeNode(nums[middle]);
		root.left = build(nums, start, middle - 1);
		root.right = build(nums, middle + 1, end);
		return root;
	}
	
	public static void main(String [] args) {
		int [] data = {1,2,3,4,5,6};
		TreeNode root = new SortedArrayToBST().sortedArrayToBST(data);
		TreeUtils utils = new TreeUtils(null);
		utils.preTravel(root);
	}
}
