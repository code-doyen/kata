package com.comresource.kata;

public class Board {
	private Integer grid[][];
	private int rows, cols;
	private int neighbors = 0;
	public final int DEAD = 0;
	public final int ALIVE = 1;
	
	public Board(int r, int c) {
		rows = r;
		cols = c;
		grid = new Integer[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j] = DEAD;
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
	
	public Integer getRows() {
		return rows;
	}
	public Integer getCols() {
		return cols;
	}
	
	public int getValue(int r, int c) {
		return grid[r][c];
	}
	public void setValue(int r, int c, int vitalStatus) {
		grid[r][c] = vitalStatus;
	}
	public boolean isAlive(int r, int c) {
		return grid[r][c] == ALIVE;
	}
	private int getNeighbors(int r, int c) {
		neighbors = 0;
		//check grid value NW
		if(r-1 >= 0 && c-1 >= 0) {
			if(this.getValue(r-1, c-1) == ALIVE)
				neighbors++;
		}
		//check grid value N
		if(r-1 >= 0) {
			if(this.getValue(r-1, c) == ALIVE)
				neighbors++;
		}
		//check grid value NE
		if(r-1 >= 0 && c+1 < this.cols) {
			if(this.getValue(r-1, c+1) == ALIVE)
				neighbors++;
		}
		//check grid value E
		if(c+1 < this.cols) {
			if(this.getValue(r, c+1) == ALIVE)
				neighbors++;
		}
		//check grid value SE
		if(r+1 < this.rows && c+1 < this.cols) {
			if(this.getValue(r+1, c+1) == ALIVE)
				neighbors++;
		}
		//check grid value S
		if(r+1 < this.rows) {
			if(this.getValue(r+1, c) == ALIVE)
				neighbors++;
		}
		//check grid value SW
		if(r+1 < this.rows && c-1 >= 0) {
			if(this.getValue(r+1, c-1) == ALIVE)
				neighbors++;
		}
		//check grid value W
		if(c-1 >= 0) {
			if(this.getValue(r, c-1) == ALIVE)
				neighbors++;
		}
		return neighbors;
	}
	public boolean underPopulation(int r, int c) {
		//Any live cell with fewer than two live neighbors dies, as if caused by under population.	
		if(this.getValue(r,c) == ALIVE)
			return this.getNeighbors(r, c) < 2;
		return false;
	}
	public boolean overCrowding(int r, int c) {
		//Any live cell with more than three live neighbors dies, as if by overcrowding.
		if(this.getValue(r,c) == ALIVE)
			return this.getNeighbors(r, c) > 3;
		return false;
	}
	public boolean nextGeneration(int r, int c) {
		//Any live cell with two or three live neighbors lives on to the next generation.
		if(this.getValue(r,c) == ALIVE) {
			int test = this.getNeighbors(r, c);
			return test == 2 || test == 3;
		}
		return false;
	}
	public boolean reincarnateCell(int r, int c) {
		//Any dead cell with exactly three live neighbors becomes a live cell. reincarnateCell()
		if(this.getValue(r,c) == DEAD)
			return this.getNeighbors(r, c) == 3;
		return false;
	}
}
