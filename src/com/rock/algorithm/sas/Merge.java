package com.rock.algorithm.sas;

import java.util.Arrays;

public class Merge {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (nums1 == null || nums2 == nums1 
				|| nums1.length < 1 || nums2.length < 1) {
			return;
		}
		int indexOfNums1 = 0, indexOfNums2 = 0, curLength = m;
		for (; indexOfNums1 < m + n && indexOfNums2 < n ; ) {
			if (nums2[indexOfNums2] <= nums1[indexOfNums1]) {
				for (int k = 0 ; k < curLength - indexOfNums1 ; k++) {
					nums1[curLength - 1 - k + 1] = nums1[curLength - 1 - k];
				}
				nums1[indexOfNums1] = nums2[indexOfNums2];
				curLength++;
				indexOfNums2++;
			} else {
				indexOfNums1++;
				continue;
			}
		}
		if (indexOfNums2 < n) {
			for (int i = 0 ; i < n - indexOfNums2 ; i++) {
				nums1[curLength + i] = nums2[indexOfNums2 + i];
			}
		}
    }
	
	// 利用Arrays工具
	public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
		if (nums1 == null || nums2 == nums1 
				|| nums1.length < 1 || nums2.length < 1) {
			return;
		}
		for (int i = 0 ; i < n ; i++) {
			nums1[m + i] = nums2[i];
		}
		Arrays.sort(nums1);
	}
	
	public static void main(String [] args) {
		int [] nums1 = new int[1];
		nums1[0] = 0;
		int [] nums2 = {1};
		new Merge().mergeV2(nums1, 0, nums2, 1);
		System.out.println(Arrays.toString(nums1));
	}
}
