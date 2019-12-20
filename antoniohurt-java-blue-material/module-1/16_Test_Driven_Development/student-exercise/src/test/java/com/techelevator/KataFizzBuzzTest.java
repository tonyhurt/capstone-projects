package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {

	private KataFizzBuzz kataFizzBuzz;

	@Before
	public void setup() {
		kataFizzBuzz = new KataFizzBuzz();

	}

	@Test
	public void is_0_test() {
		String result = kataFizzBuzz.FizzBuzzResult(0);
		Assert.assertEquals(" ", kataFizzBuzz.FizzBuzzResult(0));

	}

	@Test
	public void is_101_test() {
		String result = kataFizzBuzz.FizzBuzzResult(101);
		Assert.assertEquals(" ", kataFizzBuzz.FizzBuzzResult(101));
	}

	@Test
	public void is_mult_15_test() {
		String result = kataFizzBuzz.FizzBuzzResult(15);
		Assert.assertEquals("Fizz", kataFizzBuzz.FizzBuzzResult(15));
	}

	@Test
	public void is_1_test() {
		String result = kataFizzBuzz.FizzBuzzResult(1);
		Assert.assertEquals("1", kataFizzBuzz.FizzBuzzResult(1));

	}

	@Test
	public void is_mult_3_test() {
		String result = kataFizzBuzz.FizzBuzzResult(3);
		Assert.assertEquals("Fizz", kataFizzBuzz.FizzBuzzResult(3));

	}

	@Test
	public void is_mult_5_test() {
		String result = kataFizzBuzz.FizzBuzzResult(5);
		Assert.assertEquals("Buzz", kataFizzBuzz.FizzBuzzResult(5));
	}

	@Test
	public void is_12_test() {
		String result = kataFizzBuzz.FizzBuzzResult(12);
		Assert.assertEquals("Fizz", kataFizzBuzz.FizzBuzzResult(12));
	}

	@Test
	public void is_22_test() {
		String result = kataFizzBuzz.FizzBuzzResult(22);
		Assert.assertEquals("22", kataFizzBuzz.FizzBuzzResult(22));
	}

	@Test
	public void is_13_test() {
		String result = kataFizzBuzz.FizzBuzzResult(13);
		Assert.assertEquals("Fizz", kataFizzBuzz.FizzBuzzResult(13));

	}

	@Test
	public void is_53_test() {
		String result = kataFizzBuzz.FizzBuzzResult(53);
		Assert.assertEquals("FizzBuzz", kataFizzBuzz.FizzBuzzResult(53));
		
	}



}