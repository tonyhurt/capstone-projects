package com.techelevator.trees;

import org.junit.*;

public class FruitTreeTest {

	private FruitTree fruitTree;
	private final static String FRUIT_TYPE = "Pear";

	@Before
	public void setup() {
		fruitTree = new FruitTree("Pear", 10);
	}

	@Test
	public void tree_returns_correct_type_of_fruit() {
		Assert.assertEquals(FRUIT_TYPE, fruitTree.getTypeOfFruit());
	}

	@Test
	public void pick_5_fruit() {
		boolean result = fruitTree.pickFruit(5);
		Assert.assertTrue(result);
		Assert.assertEquals(5, fruitTree.getPiecesOfFruitLeft());
	}

	@Test
	public void pick_all_fruit() {
		boolean result = fruitTree.pickFruit(10);
		Assert.assertTrue(result);
		Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft());

	}

	@Test
	public void pick_all_fruit_plus_1() {
		boolean result = fruitTree.pickFruit(11);
		Assert.assertTrue(result);
		Assert.assertEquals(10, fruitTree.getPiecesOfFruitLeft());
	}

	@Test
	public void pick_negative_fruit() {
		boolean result = fruitTree.pickFruit(-1);
		Assert.assertFalse(result);
		Assert.assertEquals("Wrong number of fruit left: " + fruitTree.getPiecesOfFruitLeft(), 10,
				fruitTree.getPiecesOfFruitLeft());
	}
	
	@Test
	public void pick_fruit_then_rest_then_try_more() {
		//Arrange
		fruitTree.pickFruit(4);

		Assert.assertEquals(6, fruitTree.getPiecesOfFruitLeft());
		
		fruitTree.pickFruit(6);
		Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft());
		
		//Act
		boolean result = fruitTree.pickFruit(2);
		
		//Assert
		Assert.assertFalse(result);
		Assert.assertEquals(0,  fruitTree.getPiecesOfFruitLeft());
		
	}
}
