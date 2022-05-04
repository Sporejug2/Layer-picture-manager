package com.layer.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.layer.pictureManager.dao.DaoClass;

class DaoTest {

	DaoClass daoClass = new DaoClass();

	@Before
	public static void before() {
		System.out.println("Before");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After");
	}

	@Test
	public void sum_with3numbers() {

		int result = daoClass.sum(new int[] { 1, 2, 3 });
		System.out.println("Test 1");
		assertEquals(6, result);
		System.out.println(result);
	}

	@Test
	public void sum_with1number() {
		System.out.println("Test 2");
		assertEquals(3, daoClass.sum(new int[] { 3 }));
	}

}
