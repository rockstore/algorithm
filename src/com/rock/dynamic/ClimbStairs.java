package com.rock.dynamic;

public class ClimbStairs {
	
	// 非递归实现斐波那契数列
	public int climbStairs(int n) {
        if (n == 1) {
        	return 1;
        } else if (n == 2) {
        	return 2;
        } else {
        	int sum = 0;
        	int sum1 = 1, sum2 = 2;
        	for (int i = 0 ; i < n - 2 ; i++) {
        		sum = sum1 + sum2;
        		sum1 = sum2;
        		sum2 = sum;
        	}
        	return sum;
        }
    }
	
	
	// 使用递归的斐波拉契数列
	public int climbStairsV2(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return climbStairsV2(n - 1) + climbStairsV2(n - 2);
		}
	}
	
	// 穷举法
	public int climbStairsV3(int n) {
		int sum = 0;
		// i表示1的个数
        for (int i = 0 ; i <= n ; i++) {
        	if ((n - i) % 2 == 0) {
        		// tmp表示2的个数
        		int tmp = (n - i) / 2;
        		if (tmp == 0) {
        			continue;
        		}
        		sum += numOfCombination(n - tmp, tmp);
        	}
        }
        // 返回之前添加全是1这种情况
        return ++sum;
    }
	
	// 计算组合
	private int numOfCombination(int n, int m) {
		if(m <= 0 || n <= 0 || n < m) {
			return -1;
		}
		return factorial(n) / (factorial(m) * factorial(n - m));
	}
	
	// 计算m!
	private int factorial(int m) {
		if (m <= 1) {
			return 1;
		} else {
			return m * factorial(m - 1);
		}
	}
	
	public static void main(String [] args) {
		System.out.println(new ClimbStairs().climbStairs(5));
	}
}
