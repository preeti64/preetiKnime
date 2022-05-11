package org.preeti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testCases {

	@Test
	void test() {
		ClaOperations test = new ClaOperations();
		int outputNumRev = test.reverseNumber(102);
		assertEquals(201, outputNumRev);
		String outputStrRev = test.reverseString("foo");
		assertEquals("oof", outputStrRev);	
		int outputNumNeg = test.negationOfNumber(102);
		assertEquals(-102, outputNumNeg);
		String outputStrCap = test.capString("foo");
		assertEquals("FOO", outputStrCap);
	}

}
