package com.rock.algorithm.array;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        if (nums == null || nums.length < 2) {
        	return result;
        }
        int [] tmp = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
        	tmp[i] = nums[i];
        }
        bubbleSort(tmp);
        int lastSearchIndex = -1;
        for (int i = tmp.length - 1 ; i >= 0 ; i--) {
        	if (tmp[i] <= target) {
        		lastSearchIndex = i;
        		break;
        	}
        }
        if (lastSearchIndex == -1) {
        	lastSearchIndex = 0;
        }
        boolean hasFound = false;
        for (int i = lastSearchIndex ; i < tmp.length ; i++) {
        	for (int j = i - 1 ; j >= 0 ; j--) {
        		if (tmp[i] + tmp[j] == target) {
        			result[0] = indexOf(nums, tmp[i], -1);
        			result[1] = indexOf(nums, tmp[j], result[0]);
        			hasFound = true;
        			break;
        		}
        	}
        }
        if (!hasFound) {
        	for (int i = lastSearchIndex ; i >= 0 ; i--) {
            	for (int j = i + 1 ; j < tmp.length ; j++) {
            		if (tmp[i] + tmp[j] == target) {
            			result[0] = indexOf(nums, tmp[i], -1);
            			result[1] = indexOf(nums, tmp[j], result[0]);
            			break;
            		}
            	}
            }
        }
        bubbleSort(result);
        return result;
    }
	
	
	private void bubbleSort(int [] nums) {
		if (nums == null || nums.length == 1) {
			return;
		}
		for (int i = 0 ; i < nums.length ; i++) {
			for (int j = 0 ; j < nums.length - 1 ; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			}
		}
	}
	
	private int indexOf(int [] nums, int target, int except) {
		int index = -1;
		if (nums == null) {
			return index;
		}
		for (int i = 0 ; i < nums.length ; i++) {
			if (i == except) {
				continue;
			}
			if (nums[i] == target) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String [] args) {
		int [] nums = {-1,-2,-3,-4,-5};
		System.out.println(Arrays.toString(new TwoSum().twoSum(nums, -8)));
	}
}
