package com.comresource.kata;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.comresource.kata.KataView;

public class TestView {
	KataView k = new KataView();
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
	public void testSimulating() {
		assertEquals(false, k.getSimulating());
		
		k.setSimulating(true);
		assertEquals(true, k.getSimulating());
		//fail("Not yet implemented");
	}

}
