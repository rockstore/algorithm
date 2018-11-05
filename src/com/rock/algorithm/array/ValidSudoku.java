package com.rock.algorithm.array;

import java.util.HashSet;

public class ValidSudoku {
	
	/**
	 * if row contains same element
	 * if coloum contains same element
	 * if small table contains same element
	 * */
	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> container = new HashSet<>();
		for (int i = 0 ; i < 9 ; i++) {
			for (int j = 0 ; j < 9 ; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (container.contains(board[i][j])) {
					return false;
				}
				container.add(board[i][j]);
			}
			container.clear();
		}
		container.clear();
		
		for (int i = 0 ; i < 9 ; i++) {
			for (int j = 0 ; j < 9 ; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				if (container.contains(board[j][i])) {
					return false;
				}
				container.add(board[j][i]);
			}
			container.clear();
		}
		container.clear();
		
		for (int i = 0 ; i < 7 ; ) {
			for (int j = 0 ; j < 7 ;) {
				for (int m = i ; m < i + 3 ; m++) {
					for (int k = j ; k < j + 3 ; k++) {
						if (board[m][k] == '.') {
							continue;
						}
						if (container.contains(board[m][k])) {
							return false;
						}
						container.add(board[m][k]);
					}
				}
				container.clear();
				j += 3;
			}
			i += 3;
		}
		return true;
	}
	
	/**
	 * use only two cycle to solve the problem
	 * */
	public boolean isValidSudokuV2(char[][] board) {
		HashSet<Character> row = new HashSet<>();
		HashSet<Character> coloum = new HashSet<>();
		HashSet<Character> cube = new HashSet<>();
		for (int i = 0 ; i < 9 ; i++) {
			for (int j = 0 ; j < 9 ; j++) {
				
				// test whether row contains same char
				if (board[i][j] != '.') {
					if (!row.contains(board[i][j])) {
						row.add(board[i][j]);
					} else {
						return false;
					}
				}
				
				
				// test whether coloum contains same char
				if (board[j][i] != '.') {
					if (!coloum.contains(board[j][i])) {
						coloum.add(board[j][i]);
					} else {
						return false;
					}
				}
				
				
				// test whether cube contains same char
				int cubeX = i - 3 * (i / 3);
                int cubeY = j - 3 * (j / 3);
                if (board[cubeX][cubeY] != '.') {
                	if (!cube.contains(board[cubeX][cubeY])) {
                    	cube.add(board[cubeX][cubeY]);
    				} else {
    					return false;
    				}
                }
                
			}
			row.clear();
			coloum.clear();
			cube.clear();
		}
		return true;
	}
	public static void main(String [] args) {
	}
}
