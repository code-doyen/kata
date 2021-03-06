package com.comresource.kata;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.comresource.kata.KataView;

public class TestView {
	KataView k = new KataView(3, 3);
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
	public void testKataContruct() {
		assertEquals(true, k.frozen);		
		assertEquals(3, k.lifeBoard.getCols().intValue());
		assertEquals(3, k.lifeBoard.getRows().intValue());
		assertEquals(3, k.offspringBoard.getCols().intValue());
		assertEquals(3, k.offspringBoard.getRows().intValue());
		
		//fail("Not yet implemented");
	}

}
