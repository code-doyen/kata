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
				assertEquals(0, b.getValue(i,j));
			}
		}
		
		//fail("Not yet implemented");
	}
	@Test
	public void testBoardValuesUpdated() {
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				b.setValue(i, j, 1);
				assertEquals(1, b.getValue(i,j));
			}
		}
		//fail("Not yet implemented");
	}
	@Test
	public void testCloneBoard() {
		Board c = new Board(3,3);
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				b.setValue(i, j, 0);
				c.setValue(i, j, 1);
			}
		}
		b.cloneGrid(c);
		for(int i = 0; i < b.getRows(); i++) {
			for(int j = 0; j < b.getCols(); j++) {
				assertEquals(1,b.getValue(i, j));
			}
		}
		//fail("Not yet implemented");
	}

}
