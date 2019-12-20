package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTests {

	private CigarParty cigarParty;

	@Before
	public void setup() {
		cigarParty = new CigarParty();

	}

	@Test
	public void thirty_cigars_and_is_not_weekend() {
		boolean result = cigarParty.haveParty(30, false);
		Assert.assertFalse(result);

	}

	@Test
	public void fifty_cigars_and_is_not_weekend() {
		boolean result = cigarParty.haveParty(50, true);
		Assert.assertTrue(result);

	}

	@Test
	public void seventy_cigars_and_is_not_weekend() {
		boolean result = cigarParty.haveParty(70, false);
		Assert.assertFalse(result);
	}

	@Test
	public void one_cigar_and_is_not_weekend() {
		boolean result = cigarParty.haveParty(1, false);
		Assert.assertFalse(result);

	}

	@Test
	public void two_hundred_cigars_and_is_not_weekend() {
		boolean result = cigarParty.haveParty(200, false);
		Assert.assertFalse(result);

	}

	@Test
	public void ten_cigars_and_is_weekend() {
		boolean result = cigarParty.haveParty(10, false);
		Assert.assertFalse(result);

	}

	@Test
	public void ninety_cigars_and_is_weekend() {
		boolean result = cigarParty.haveParty(90, true);
		Assert.assertTrue(result);
	}
}
