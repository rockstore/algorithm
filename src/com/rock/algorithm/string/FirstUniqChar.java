package com.rock.algorithm.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
	// firstUniqChar v1
	public int firstUniqChar(String s) {
		if (s == null) {
			return -1;
		}
		s = s.trim();
        if (s.length() == 1) {
        	return 0;
        }
        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
        	char c = s.charAt(i);
        	if (!counts.containsKey(c)) {
        		counts.put(c, 1);
        	} else {
        		int num = counts.get(c);
        		counts.put(c, ++num);
        	}
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
        	if (entry.getValue() == 1) {
        		return s.indexOf((char)entry.getKey());
        	}
        }
        return -1;
    }
	
	// slow in time
	public int firstUniqCharV2(String s) {
		if (s == null) {
			return -1;
		}
		s = s.trim();
		if (s.length() == 1) {
			return 1;
		}
		for (int i = 0 ; i < s.length() ; i++) {
			if (isUnique(s, s.charAt(i), i + 1)) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean isUnique(String s, char c, int start) {
		if (s == null) {
			return false;
		}
		for (int i = start ; i < s.length() ; i++) {
			if (c == s.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args) {
		String test = "loveleetcode";
		System.out.println(new FirstUniqChar().firstUniqChar(test));
	}
	
}
