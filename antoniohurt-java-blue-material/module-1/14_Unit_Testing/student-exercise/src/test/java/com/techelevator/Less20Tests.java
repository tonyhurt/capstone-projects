package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Tests {

	private Less20 less20;

	@Before
	public void setup() {
		less20 = new Less20();
	}

	@Test
	public void two_less_multiple_twenty() {
		boolean result = less20.isLessThanMultipleOf20(18);
		Assert.assertTrue(result);

	} 

	@Test
	public void one_less_multiple_twenty() {
		boolean result = less20.isLessThanMultipleOf20(19);
		Assert.assertTrue(result);
	}

	@Test
	public void three_less_multiple_twenty() {
		boolean result = less20.isLessThanMultipleOf20(10);
		Assert.assertFalse(result);
	}

	@Test
	public void five_less_multiple_twenty() {
		boolean result = less20.isLessThanMultipleOf20(15);
		Assert.assertFalse(result);
	}

	@Test
	public void two_more_multiple_twenty() {
		boolean result = less20.isLessThanMultipleOf20(25);
		Assert.assertFalse(result);

	}
}