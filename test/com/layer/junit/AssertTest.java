package com.layer.junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class AssertTest {

	@Test
	void test() {
		assertEquals(1, 1);
		boolean condn = true;
		assertTrue(condn);
		assertEquals(true, true);
		assertFalse(condn);
		// assertNotNull();
		assertNull(getClass());
		// assertArrayEquals(expected, actuals);
	}

}
