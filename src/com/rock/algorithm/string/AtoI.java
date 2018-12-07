package com.rock.algorithm.string;

public class AtoI {
	
	/**
	 * notice:
	 * 		1. + -
	 * 		2. 000001212xxxx
	 * 		3. Integer.MIN_VALUE
	 * */
	public int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		String tmp = str.trim();
		if (tmp.length() < 1) {
			return 0;
		}
		if (tmp.length() == 1) {
			char ch = tmp.charAt(0);
			if (!isValidNumber(ch)) {
				return 0;
			} else {
				return Integer.parseInt(tmp);
			}
		}
		char first = tmp.charAt(0);
		if (!isValidAtStart(first)) {
			return 0;
		}
		boolean isPositive = true;
		boolean hasStart = false;
		boolean hasNonZeroChar = false;
		StringBuilder resultTmp = new StringBuilder();
		for (int i = 0 ; i < tmp.length() ; i++) {
			char ch = tmp.charAt(i);
			if (!hasStart && isValidAtStart(ch)) {
				hasStart = true;
				if (ch == '-') {
					isPositive = false;
					continue;
				} 
				if (ch == '+') {
					continue;
				}
			}
			if (hasStart) {
				if (isValidNumber(ch)) {
					if (!hasNonZeroChar && ch != '0') {
						hasNonZeroChar = true;
					}
					if (ch == '0' && !hasNonZeroChar) {
						continue;
					}
					hasStart = true;
					resultTmp.append(ch);
				} else {
					break;
				}
			}
		}
		try {
			String result = resultTmp.toString();
			System.out.println(result);
			if (isPositive) {
				String maxStr = String.valueOf(Integer.MAX_VALUE);
				if ((result.length() == maxStr.length() && result.compareTo(maxStr) > 0)
						|| result.length() > maxStr.length()) {
					return Integer.MAX_VALUE;
				}
			} else {
				String minStr = String.valueOf(Integer.MIN_VALUE).substring(1);
				if ((result.length() == minStr.length() && result.compareTo(minStr) > 0)
						|| result.length() > minStr.length()) {
					return Integer.MIN_VALUE;
				}
			}
			return Integer.parseInt((isPositive ? "" : "-") + result);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
        
    }
	
	private boolean isValidAtStart(char ch) {
		return isValidNumber(ch) || ch == '+' || ch == '-';
	}
	
	private boolean isValidNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	public static void main(String [] args) {
		String test = "-2147483649";
		System.out.println(Integer.MIN_VALUE);
		System.out.println(new AtoI().myAtoi(test));
	}
}
