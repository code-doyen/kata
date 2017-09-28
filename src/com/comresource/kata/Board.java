package com.comresource.kata;

public class Board {
	private Integer grid[][];
	private int rows, cols;
	private int units;
	
	public Board(int r, int c) {
		rows = r;
		cols = c;
		units = r * c;
		grid = new Integer[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j] = 0;
			}
		}
	}
	public void cloneGrid(Board g) {
		for(int i = 0; i < g.getRows(); i++) {
			for(int j = 0; j < g.getCols(); j++) {
				this.setValue(i, j, g.getValue(i,j));
			}
		}
	}
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	public int getUnits() {
		return units;
	}
	public int getValue(int r, int c) {
		return grid[r][c];
	}
	public void setValue(int r, int c, int vitalStatus) {
		grid[r][c] = vitalStatus;
	}
}
