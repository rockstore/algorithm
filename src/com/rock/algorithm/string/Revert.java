package com.rock.algorithm.string;

import java.util.Stack;

public class Revert {
	
	// use stack to revert string
	public String reverseString(String s) {
        if (s == null || s.length() < 2) {
        	return s;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++) {
        	stack.push(s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
        	builder.append(stack.pop());
        }
        return builder.toString();
    }
	
	// use stringbuffer.reverse
	public String revertStringV2(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		return new StringBuffer(s).reverse().toString();
	}
	// use array to swap char element
	public String revertStringV3(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		char [] ret = s.toCharArray();
		char tmp;
		for (int i = 0 ; i < ret.length / 2 ; i++) {
			tmp = ret[i];
			ret[i] = ret[ret.length - i - 1];
			ret[ret.length - i - 1] = tmp;
		}
		return new String(ret);
	}
	
	// scanning from last index
	public String revertStringV4(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = s.length() - 1 ; i >= 0 ; i--) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}
	
	public static void main(String [] args) {
		String test = "hello world, this is qihoo 360";
		System.out.println(new Revert().revertStringV4(test));
	}
}
