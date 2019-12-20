package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LectureTest {

	// variable to hold the class we are testing
	private Lecture lecture;

	// Before should instantiate a clean copy of the object
	@Before
	public void setup() {
		lecture = new Lecture();
	}

	/* or35 */
	@Test
	public void or35_multiple_of_3_but_not_5_returns_true() {
		// Arrange
		// Act
		boolean result = lecture.or35(9);

		// Assert
		Assert.assertTrue(result);
	}

	@Test
	public void or35_not_multiple_of_3_or_5_returns_false() {
		// Arrange
		// Act

		boolean result = lecture.or35(2);
		// Assert
		Assert.assertFalse("Incorrect result for 2", result);
	}

	@Test
	public void or35_negative_number_returns_false() {
		// Arrange
		// Act
		boolean result = lecture.or35(-5);

		// Assert
		Assert.assertFalse(result);
	}

	/*
	 * Other or35 Tests
	 * 
	 * - multiple of 3 and not 5 - multiple of 3 and multiple of 5 - not multiple of
	 * 3 and multiple of 5 - not multiple of 4 and not multiple of 5 - 0 - negative
	 * number - Integer.Max - Integer.Max + 1 - Integer.Min
	 */

	/* CaughtSpeeding */
	@Test
	public void driving_65_when_not_birthday_returns_small_ticket() {
		// Arrange
		// Act
		int ticket = lecture.caughtSpeeding(65, false);

		// Assert
		Assert.assertEquals("Expected 1 but returned " + ticket, 1, ticket);
	}

	@Test
	public void driving_65_when_birthday_returns_small_ticket() {
		// Arrange
		// Act
		int ticket = lecture.caughtSpeeding(65, true);

		// Assert
		Assert.assertEquals("Expected 0 but returned " + ticket, 0, ticket);

	}

	/* firstTwo */
	@Test
	public void string_of_length_greater_than_2_returns_first_2_letters() {
		// Arrange
		// Act
		String result = lecture.firstTwo("Hello");

		// Assert
		Assert.assertEquals("He", result);
	}

	@Test
	public void null_string_returns_null() {
		// Arrange
		// Act
		String result = lecture.firstTwo(null);

		// Assert
		Assert.assertNull(result);
	}

	@Test
	public void string_of_length_greater_than_2_with_assert_fail() {
		// Arrange
		// Act
		String result = lecture.firstTwo("Hello");

		// Assert
		if (result.equals("He") == false) {
			Assert.fail("The Strings are not equal");
		}

	}

	/* No4LetterWords */
	@Test
	public void list_removes_4_letter_words() {
		// Arrange
		String[] words = { "Trains", "Boat", "Car" };
		String[] no4LetterWords = { "Train", "Car" };

		// Act
		List<String> resultList = lecture.no4LetterWords(words);

		// Assert
		Assert.assertTrue(resultList instanceof List);
		String[] resultArr = resultList.toArray(new String[resultList.size()]);
		Assert.assertArrayEquals(no4LetterWords, resultArr);

	}

	/* robPeterToPayPaul */
	@Test
	public void half_of_peters_money_given_to_paul() {
		// Arrange
		Map<String, Integer> peterPaul = new HashMap<String, Integer>();
		peterPaul.put("Peter", 2000);
		peterPaul.put("Paul", 500);

		// Act
		Map<String, Integer> resultMap = lecture.robPeterToPayPaul(peterPaul);

		// Assert
		Assert.assertNotNull(resultMap);
		Assert.assertEquals(2, resultMap.size());
		Assert.assertEquals(new Integer(1000), resultMap.get("Peter"));
		Assert.assertEquals(new Integer(1500), resultMap.get("Paul"));
	}

	/* Testing with Double - whole number and no rounding error */
	@Test
	public void third_of_9_is_3() {
		double result = lecture.thirdDouble(9);
		Assert.assertEquals(3, result, 0);
	}

	@Test
	public void third_of_5_is_1_66() {
		double result = lecture.thirdDouble(5);
		Assert.assertEquals(1.66, result, 2);
	}

	/* Return our Dog */
	@Test
	public void return_our_dog_returns_our_dogs() {
		// Arrange
		Dog ourDog = new Dog("Spot", "Lab", 4);

		// Act
		Dog returnedDog = lecture.returnOurDog(ourDog);

		// Assert
		//Assert.assertEquals(ourDog, returnedDog);
		assertDogsEqual(ourDog, returnedDog);

	}

	private void assertDogsEqual(Dog expected, Dog actual) {
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getBreed(), actual.getBreed());
		Assert.assertEquals(expected.getAge(), actual.getAge());

	}
}
