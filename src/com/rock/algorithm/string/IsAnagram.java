package com.rock.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
	
	// v1 sort letter the compare each letter
	public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        } 
        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0 ; i < sArr.length ; i++) {
        	if (sArr[i] != tArr[i]) {
        		return false;
        	}
        }
        return true;
    }
	
	// v2 use hashmap
	public boolean isAnagramV2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        }
        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
        	char c = s.charAt(i);
        	if (!count1.containsKey(c)) {
        		count1.put(c, 1);
        	} else {
        		count1.put(c, count1.get(c) + 1);
        	}
        }
        for (int i = 0 ; i < t.length() ; i++) {
        	char c = t.charAt(i);
        	if (!count2.containsKey(c)) {
        		count2.put(c, 1);
        	} else {
        		count2.put(c, count2.get(c) + 1);
        	}
        }
        if (count1.entrySet().size() != count2.entrySet().size()) {
        	return false;
        }
        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
        	char key = entry.getKey();
        	if (entry.getValue() != count2.get(key)) {
        		return false;
        	} 
        }
        return true;
    }
	
	// count number of each letter using int array
	public boolean isAnagramV3(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int [] counts = new int[26];
		int [] countt = new int[26];
		for (int i = 0 ; i < s.length() ; i++) {
			counts[s.charAt(i) - 'a']++;
		}
		for (int i = 0 ; i < t.length() ; i++) {
			countt[t.charAt(i) - 'a']++;
		}
		for (int i = 0 ; i < 26 ; i++) {
			if (counts[i] != countt[i]) {
				return false;
			}
		}
        return true;
    }
	public static void main(String [] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(new IsAnagram().isAnagramV3(s, t));
	}
}
