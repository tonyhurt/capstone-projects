package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTests {

	private FrontTimes frontTimes;

	@Before
	public void setup() {
		frontTimes = new FrontTimes();
	}

	@Test
	public void chocolate_2_test() {
		String result = frontTimes.generateString("chocolate", 2);
		Assert.assertEquals("chocho", result);
	}
 
	@Test 
	public void chocolate_3_test() {
		String result = frontTimes.generateString("chocolate", 3);
		Assert.assertEquals("chochocho", result);

	}

	@Test
	public void abc_3_test() {
		String result = frontTimes.generateString("Abc", 3);
		Assert.assertEquals("AbcAbcAbc", result);

	}

	@Test
	public void ab_2_test() {
		String result = frontTimes.generateString("Ab", 2);
		Assert.assertEquals("AbAb", result);
	}

	@Test
	public void a_1_test() {
		String result = frontTimes.generateString("A", 1);
		Assert.assertEquals("A", result);
		
	  
	}
}
