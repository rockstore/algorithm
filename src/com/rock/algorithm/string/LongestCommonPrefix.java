package com.rock.algorithm.string;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        }
        if (strs.length == 1) {
        	return strs[0];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0 ; i < strs.length ; i++) {
        	if (strs[i] != null) {
        		if (strs[i].length() < minLength) {
        			minLength = strs[i].length();
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        boolean isPrefix = true;
        for (int i = 0 ; i < minLength ; i++) {
        	char ch = strs[0].charAt(i);
        	isPrefix = true;
        	for (int j = 1 ; j < strs.length ; j++) {
        		if (ch != strs[j].charAt(i)) {
        			isPrefix = false;
        		}
        	}
        	if (isPrefix) {
        		sb.append(ch);
        	} else {
        		break;
        	}
        }
        return sb.toString();
    }
	
	public String longestCommonPrefixV2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int pos = 0;
		for (int i = 0 ; i < strs[0].length() ; i++) {
			char ch = strs[0].charAt(0);
			for (String str : strs) {
				if (str.length() == i || ch != str.charAt(pos)) {
                    return str.substring(0, i);
                }
			}
			pos++;
		}
		return strs[0].substring(0, pos);
	}
	
	public static void main(String [] args) {
		String [] strs = new String[] {"aca", "cba"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefixV2(strs));
	}
}
