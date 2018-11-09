package com.rock.algorithm.array;

public class Rotate {
	/**
	 * 1、找到待旋转的四个元素的位置规律
	 * 2、找到旋转初始的四个元素的位置
	 * 3、四个元素使用交换的方式进行旋转
	 * */
	public void rotate(int[][] matrix) {
		int length = matrix.length;
        int limit = (length - 1) / 2;
        for(int i = 0 ; i <= limit ; i++){
            for(int j = i ; j < length-1-i ; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length-1-j][i];
                matrix[length-1-j][i] = matrix[length-1-i][length-1-j];
                matrix[length-1-i][length-1-j] = matrix[j][length-1-i];
                matrix[j][length-1-i] = tmp;
            }
        }
    }
	

	public static void main(String [] args) {
		int [][] data = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		new Rotate().rotate(data);
		for (int i = 0 ; i < data.length ; i++) {
			for (int j = 0 ; j < data.length ; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}
}
