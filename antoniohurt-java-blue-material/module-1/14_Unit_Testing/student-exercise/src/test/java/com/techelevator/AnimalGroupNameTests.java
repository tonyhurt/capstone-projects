package com.techelevator;

import org.junit.*;

public class AnimalGroupNameTests {
	
	private AnimalGroupName animalGroupName;
	
	@Before
	public void setup() {
		animalGroupName = new AnimalGroupName();
	}
	
	@Test
	public void get_herd_giraffe_returns_tower() {
		String result = animalGroupName.getHerd("GIRAFFE".toLowerCase());
		Assert.assertEquals("Tower", result);
	}
	 
	@Test
	public void get_herd_empty_string_returns_unknown() {
		String result = animalGroupName.getHerd("".toLowerCase());
		Assert.assertEquals("unknown", result);
	}
	 
	@Test
	public void animalname_null_should_return_null() {
		String result = animalGroupName.getHerd(null);
		Assert.assertNull(result);
	}
	
	@Test
	public void get_herd_walrus_returns_unknown() {
		String result = animalGroupName.getHerd("WALRUS".toLowerCase());
		Assert.assertEquals("unknown", result);
	} 
	@Test
	public void get_herd_elephants_returns_unknown() {
		String result = animalGroupName.getHerd("ELEPHANTS".toLowerCase());
		Assert.assertEquals("unknown", result);
	}
	
	@Test
	public void get_herd_crocodile_returns_Float() {
		String result = animalGroupName.getHerd("CROCODILE".toLowerCase());
		Assert.assertEquals("Float", result);
	}

}
