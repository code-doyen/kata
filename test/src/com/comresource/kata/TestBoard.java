package com.comresource.kata;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.comresource.kata.Board;

public class TestBoard {
	Board b = new Board(3,3);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBoardInitiated() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				assertEquals(b.DEAD, b.getValue(i,j));
			}
		}
		
		//fail("Not yet implemented");
	}
	@Test
	public void testBoardValuesUpdated() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				b.setValue(i, j, 1);
				assertEquals(b.ALIVE, b.getValue(i,j));
			}
		}
		//fail("Not yet implemented");
	}
	@Test
	public void testCloneBoard() {
		Board c = new Board(3,3);
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				b.setValue(i, j, b.DEAD);
				c.setValue(i, j, c.ALIVE);
			}
		}
		b.cloneGrid(c);
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				
			}
		}
		//fail("Not yet implemented");
	}
	@Test
	public void testUnderPopulation() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
					b.setValue(i, j, b.ALIVE);
			}	
		}
		b.setValue(0, 0, b.DEAD);
		b.setValue(0, 2, b.DEAD);
		b.setValue(1, 1, b.DEAD);
		b.setValue(2, 0, b.DEAD);
		b.setValue(2, 2, b.DEAD);
		assertEquals(false, b.underPopulation(0, 0));
		assertEquals(false, b.underPopulation(0, 1));
		assertEquals(false, b.underPopulation(0, 2));
		assertEquals(false, b.underPopulation(1, 0));
		assertEquals(false, b.underPopulation(1, 1));
		assertEquals(false, b.underPopulation(1, 2));
		assertEquals(false, b.underPopulation(2, 0));
		assertEquals(false, b.underPopulation(2, 1));
		assertEquals(false, b.underPopulation(2, 2));
		b.setValue(0, 1, b.DEAD);
		b.setValue(1, 0, b.DEAD);
		assertEquals(true, b.underPopulation(1, 2));
		assertEquals(true, b.underPopulation(2, 1));
		//fail("Not yet implemented");
	}
	@Test
	public void testOverCrowding() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
					b.setValue(i, j, b.ALIVE);
			}
		}
		b.setValue(0, 1, b.DEAD);
		b.setValue(1, 0, b.DEAD);
		b.setValue(1, 2, b.DEAD);
		b.setValue(2, 1, b.DEAD);
		assertEquals(false, b.overCrowding(0, 0));
		assertEquals(false, b.overCrowding(0, 2));
		assertEquals(false, b.overCrowding(2, 0));
		assertEquals(false, b.overCrowding(2, 2));
		assertEquals(true, b.overCrowding(1, 1));
		assertEquals(false, b.overCrowding(0, 1));
		
		//fail("Not yet implemented");
	}
	@Test
	public void testNextGeneration() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
					b.setValue(i, j, b.ALIVE);
			}	
		}
		b.setValue(1, 0, b.DEAD);
		b.setValue(1, 2, b.DEAD);
		assertEquals(true, b.nextGeneration(0, 0));
		assertEquals(true, b.nextGeneration(0, 1));
		assertEquals(true, b.nextGeneration(0, 2));
		assertEquals(false, b.nextGeneration(1, 0));
		assertEquals(false, b.nextGeneration(1, 1));
		assertEquals(false, b.nextGeneration(1, 2));
		assertEquals(true, b.nextGeneration(2, 0));
		assertEquals(true, b.nextGeneration(2, 1));
		assertEquals(true, b.nextGeneration(2, 2));
		
		//fail("Not yet implemented");
	}
	@Test
	public void testReincarnateCell() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
					b.setValue(i, j, b.ALIVE);
			}	
		}
		b.setValue(0, 0, b.DEAD);
		b.setValue(0, 2, b.DEAD);
		b.setValue(2, 0, b.DEAD);
		b.setValue(2, 2, b.DEAD);
		assertEquals(true, b.reincarnateCell(0, 0));
		assertEquals(false, b.reincarnateCell(0, 1));
		assertEquals(true, b.reincarnateCell(0, 2));
		assertEquals(false, b.reincarnateCell(1, 0));
		assertEquals(false, b.reincarnateCell(1, 1));
		assertEquals(false, b.reincarnateCell(1, 2));
		assertEquals(true, b.reincarnateCell(2, 0));
		assertEquals(false, b.reincarnateCell(2, 1));
		assertEquals(true, b.reincarnateCell(2, 2));
		b.setValue(1, 1, b.DEAD);
		assertEquals(false, b.reincarnateCell(1, 1));
		
		//fail("Not yet implemented");
	}
	
//	Update cells with dead(0) or alive(1) based on the following criteria
//	A cell’s neighbors are those cells which are horizontally, vertically or diagonally adjacent. Most cells will have eight neighbors. Cells placed on the edge of the grid will have fewer.
//	Any live cell with fewer than two live neighbors dies, as if caused by under population. underPopulation()
//	Any live cell with more than three live neighbors dies, as if by overcrowding. overCrowding()
//	Any live cell with two or three live neighbors lives on to the next generation. nextGeneration()
//	Any dead cell with exactly three live neighbors becomes a live cell. reincarnateCell()
}
