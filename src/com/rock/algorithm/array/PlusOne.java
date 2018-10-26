package com.rock.algorithm.array;

import java.util.Arrays;

public class PlusOne {
	public int[] plusOne(int[] digits) {
       int [] ret;
		if (digits == null) {
			return new int [] {0};
		} else {
			int lastIndex = digits.length - 1;
			if (digits[lastIndex] + 1 < 10) {
				digits[lastIndex] = digits[lastIndex] + 1;
			} else if (digits[lastIndex] + 1 == 10) {
				if (lastIndex == 0) {
					ret = new int[2];
					ret[1] = 0;
					ret[0] = 1;
					return ret;
				} else {
					digits[lastIndex] = 0;
					digits[lastIndex - 1] = digits[lastIndex - 1] + 1;
					for (int i = lastIndex - 1 ; i >= 0 ; i--) {
						if (digits[i] < 10) {
							return digits;
						} else {
							digits[i] = 0;
							if (i == 0) {
								ret = new int[digits.length + 1];
								System.arraycopy(digits, 0, ret, 1, digits.length);
								ret[0] = 1;
								return ret;
							}
							digits[i - 1] = digits[i - 1] + 1;
						}
					}
				}
			}
		}
		return digits; 
    }
	public static void main(String [] args) {
		int [] arr1 = {9,9,9,9};
		System.out.println(Arrays.toString(new PlusOne().plusOne(arr1)));
	}
}
