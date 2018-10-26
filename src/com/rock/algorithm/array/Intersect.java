package com.rock.algorithm.array;

import java.util.Arrays;

public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
      if (nums1 == null || nums2 == null
				|| nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		
		SortUtils.bubbleSort(nums1);
		SortUtils.bubbleSort(nums2);
		
		int min1 = nums1[0];
		int max1 = nums1[nums1.length - 1];
		int min2 = nums2[0];
		int max2 = nums2[nums2.length - 1];
		
		if (max1 < min2) {
			return new int[0];
		}
		if (max2 < min1) {
			return new int[0];
		}
		
		int min = min1 > min2 ? min1 : min2, max = max1 > max2 ? max2 : max1;
		
		int start1 = firstIndexOfSortedNums(nums1, min);
		int start2 = firstIndexOfSortedNums(nums2, min);
		if (start1 == -1 || start2 == -1) {
			return new int[0];
		}
		
		int last1 = lastIndexOfSortedNums(nums1, max);
		int last2 = lastIndexOfSortedNums(nums2, max);
		
		int delta1 = last1 - start1 + 1, delta2 = last2 - start2 + 1;
		int length = delta1 > delta2 ? delta2 : delta1;
		int [] tmp = new int[length];
		int index = 0;
		
		
		for (int i = start1, j = start2 ; i <= last1 && j<= last2 ;) {
			if (nums1[i] == nums2[j]) {
				tmp[index++] = nums1[i];
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		int [] result = new int[index];
		for (int i = 0 ; i < index ; i++) {
			result[i] = tmp[i];
		}
		return result;
    }
    
    public int firstIndexOfSortedNums(int [] nums, int value) {
		if (nums == null) {
			return -1;
		}
		for (int i = 0 ; i < nums.length ; i++) {
			if (value <= nums[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOfSortedNums(int [] nums, int value) {
		if (nums == null) {
			return -1;
		}
		int ret = -1;
		for (int i = 0 ; i < nums.length ; i++) {
			ret = i;
			if (nums[i] > value) {
				break;
			}
		}
		return ret;
	}
	
	public static void main(String [] args) {
		int [] arr1 = {3,5,7,1,1,2,6,3};
		int [] arr2 = {2,1,1,7,9};
		Intersect intersect = new Intersect();
		System.out.println(Arrays.toString(intersect.intersect(arr1, arr2)));
	}
}
