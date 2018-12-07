package com.rock.algorithm.string;


public class Reverse {
	// reverse an int number using string reverse
	public int reverse(int x) {
		if (x == 0) {
			return x;
		} else if (x > 0) {
			String num = String.valueOf(x);
			num = revertStringV2(num).trim();
			long tmp = Long.parseLong(num);
			if (tmp > Math.pow(2, 31) - 1) {
				return 0;
			} else {
				return Integer.parseInt(num);
			}
		} else {
			String num = String.valueOf(x).substring(1);
			num = revertStringV2(num).trim();
			long tmp = Long.parseLong(num);
			if (0 - tmp < -Math.pow(2, 31)) {
				return 0;
			} else {
				return 0 - Integer.parseInt(num);
			}
		}
	}
	// reverse an int number using bit
	public int reverseV2(int x) {
		long ret = 0;
		while (x != 0) {
			ret = ret * 10 + (x % 10);
			x /= 10;
		}
		if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) ret;
	}
	
	public String revertStringV2(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		return new StringBuffer(s).reverse().toString();
	}
	public static void main(String [] args) {
		System.out.println(new Reverse().reverseV2(-501));
	}
}
