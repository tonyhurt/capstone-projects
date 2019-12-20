package com.techelevator;

import org.junit.*;

public class DateFashionTests {

	private DateFashion dateFashion;

	@Before
	public void setup() {
		dateFashion = new DateFashion();

	}

	@Test
	public void no_table_test() {
		int result = dateFashion.getATable(2, 10);
		Assert.assertEquals(0, result);

	}

	@Test
	public void no_table_test_2() {
		int result = dateFashion.getATable(2, 2);
		Assert.assertEquals(0, result);

	}

	@Test
	public void yes_table_test() {
		int result = dateFashion.getATable(8, 8);
		Assert.assertEquals(2, result);

	}

	@Test
	public void yes_table_test_2() {
		int result = dateFashion.getATable(7, 9);
		Assert.assertEquals(2, result);

	}

	@Test
	public void maybe_table_test() {
		int result = dateFashion.getATable(5, 6);
		Assert.assertEquals(1, result);

	}

	@Test
	public void maybe_table_test_2() {
		int result = dateFashion.getATable(4, 5);
		Assert.assertEquals(1, result);
	}

	@Test
	public void no_table_test_date_below_8() {
		int result = dateFashion.getATable(8, 2);
		Assert.assertEquals(0, result);

	}

	@Test
	public void table_test_me_below_8() {
		int result = dateFashion.getATable(3, 9);
		Assert.assertEquals(2, result);
	}

	@Test
	public void table_test_return_below_8_1() {
		int result = dateFashion.getATable(7, 7);
		Assert.assertEquals(1, result);
	}
}