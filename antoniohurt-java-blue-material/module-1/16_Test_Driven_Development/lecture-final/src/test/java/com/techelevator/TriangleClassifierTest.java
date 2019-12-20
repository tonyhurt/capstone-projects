package com.techelevator;

import org.junit.*;

public class TriangleClassifierTest {

	private TriangleClassifier classifier;
	
	@Before
	public void setup() {
		classifier = new TriangleClassifier();
	}
	
	@Test
	public void identifies_equilateral() {
		String type = classifier.classify(4, 4, 4);
		Assert.assertEquals("equilateral", type);
	}
	
	@Test
	public void identifies_isosceles() {
		Assert.assertEquals("isosceles", classifier.classify(2, 2, 3));
		Assert.assertEquals("isosceles", classifier.classify(2, 3, 2));
		Assert.assertEquals("isosceles", classifier.classify(3, 2, 2));
	}
	
	@Test
	public void identifies_scalene() {
		Assert.assertEquals("scalene", classifier.classify(2, 3, 4));
	}
	
	@Test
	public void identifies_invalid_triangle() {
		Assert.assertEquals("invalid", classifier.classify(1, 2, 3));
		Assert.assertEquals("invalid", classifier.classify(1, 3, 2));
		Assert.assertEquals("invalid", classifier.classify(2, 1, 3));
		Assert.assertEquals("invalid", classifier.classify(2, 3, 1));
		Assert.assertEquals("invalid", classifier.classify(3, 1, 2));
		Assert.assertEquals("invalid", classifier.classify(3, 2, 1));
		
		Assert.assertEquals("invalid", classifier.classify(1, 2, 5));
		Assert.assertEquals("invalid", classifier.classify(1, 5, 2));
		Assert.assertEquals("invalid", classifier.classify(2, 1, 5));
		Assert.assertEquals("invalid", classifier.classify(2, 5, 1));
		Assert.assertEquals("invalid", classifier.classify(5, 1, 2));
		Assert.assertEquals("invalid", classifier.classify(5, 2, 1));
	}
	
	@Test
	public void identifies_invalid_with_2_equal_sides() {
		Assert.assertEquals("invalid", classifier.classify(2, 2, 5));
		Assert.assertEquals("invalid", classifier.classify(2, 5, 2));
		Assert.assertEquals("invalid", classifier.classify(5, 2, 2));
	}
	
	@Test
	public void identifiers_invalid_with_side_of_zero() {
		Assert.assertEquals("invalid", classifier.classify(0, 2, 2));
		Assert.assertEquals("invalid", classifier.classify(0, 0, 0));
	}
	
	@Test
	public void identifies_invalid_with_negative_sides() {
		Assert.assertEquals("invalid", classifier.classify(-1, 2, 2));
		Assert.assertEquals("invalid", classifier.classify(-2, -2, -2));
	}
	

	
}
