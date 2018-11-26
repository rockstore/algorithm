package com.rock.algorithm.string;

public class Palindrome {
	
	// v1
	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
        	return true;
        }
        int low = 0, high = s.length() - 1;
        char l, h;
        for (;low <= high;) {
        	l = s.charAt(low);
        	h = s.charAt(high);
        	if (!isValidChar(l)) {
        		low++;
        		continue;
        	}
        	if (!isValidChar(h)) {
        		high--;
        		continue;
        	}
        	if (!String.valueOf(l).toLowerCase().equals(String.valueOf(h).toLowerCase())) {
        		return false;
        	}
        	low++;
        	high--;
        }
        return true;
    }
	
	// use reverse, nb!!!
	public boolean isPalindromeV2(String s) {
		if (s == null || s.length() == 1) {
        	return true;
        }
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < s.length() ; i++) {
			if (isValidChar(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		String tmp = sb.toString().toLowerCase();
		String reverse = new StringBuffer(tmp).reverse().toString();
		return tmp.equals(reverse);
	}
	
	public boolean isPalindromeV3(String s) {
		if (s == null || s.length() == 1) {
        	return true;
        }
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < s.length() ; i++) {
			if (isValidChar(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		String tmp = sb.toString().toLowerCase();
		int half = tmp.length() / 2;
		for (int i = 0 ; i < half ; i++) {
			if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidChar(char ch) {
		return ch >= 'a' && ch <= 'z' ||
				ch >= 'A' && ch <= 'Z' ||
				ch >= '0' && ch <= '9';
	}
	
	public static void main(String [] args) {
		String test = "0P";
		System.out.println(new Palindrome().isPalindromeV3(test));
	}
}
