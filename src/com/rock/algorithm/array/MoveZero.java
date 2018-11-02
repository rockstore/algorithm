package com.rock.algorithm.array;

import java.util.Arrays;

public class MoveZero {
	public void moveZero(int [] nums) {
		if (nums == null) {
			return;
		}
		int indexOf0 = indexOfFirstZero(nums, 0);
		int indexOfNon0 = indexOfFirstNonZero(nums, 0);
		
		if (indexOf0 == -1 || indexOf0 == nums.length -1) {
			return;
		}
		
		if (indexOfNon0 == -1) {
			return;
		}
		
		for (int i = indexOf0, j = indexOfNon0 ; i < nums.length && j < nums.length ;) {
			if (i < j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			i = indexOfFirstZero(nums, i);
			j = indexOfFirstNonZero(nums, i);
			if (i == -1 || j == -1) {
				break;
			}
		}
		
	}
	
	
	private int indexOfFirstZero(int [] nums, int start) {
		int index = -1;
		if (start < 0 || nums == null) {
			return index;
		}
		for (int i = start ; i < nums.length ; i++) {
			if (nums[i] == 0) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	private int indexOfFirstNonZero(int [] nums, int start) {
		int index = -1;
		if (start < 0 || nums == null) {
			return index;
		}
		for (int i = start ; i < nums.length ; i++) {
			if (nums[i] != 0) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String [] args) {
		int [] nums = {1,0,0};
		new MoveZero().moveZero(nums);
		System.out.println(Arrays.toString(nums));
	}
}
