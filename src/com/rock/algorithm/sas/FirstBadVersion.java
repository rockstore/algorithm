package com.rock.algorithm.sas;

public class FirstBadVersion {
	
	private boolean isBadVersion(int version) {
		return true;
	}
	// Ë³ÐòËÑË÷ËÑË÷
	public int firstBadVersion(int n) {
        for (int i = 1 ; i <= n ; i++) {
        	if (isBadVersion(i)) {
        		return i;
        	}
        }
        return -1;
    }
	
	// ¶þ·Ö²éÕÒ
	int firstBadVersionV2(int n) {
        if (isBadVersion(1)) { 
        	return 1;
        }
        int low = 1, high = n;
        int mid;
        while(low < high) {
            mid= (low + high) / 2;
            if (isBadVersion(mid)) {
            	high=mid;
            } else {
            	low = mid + 1;
            }
        }
        return low;
    }
	
	public static void main(String [] args) {
		
	}
}
