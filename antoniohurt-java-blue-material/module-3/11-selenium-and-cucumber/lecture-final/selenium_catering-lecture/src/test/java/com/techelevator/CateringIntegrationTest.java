package com.techelevator;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techelevator.pageobject.AvailableSpacesPage;
import com.techelevator.pageobject.SelectVenuePage;

public class CateringIntegrationTest {

	private static WebDriver webDriver;
	private SelectVenuePage venuePage;
	
	@BeforeClass
	public static void openWebBrowserForTesting() {
		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		venuePage = new SelectVenuePage(webDriver);
		webDriver.get("http://localhost:8080/selenium-catering-lecture-final/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void corect_number_of_available_spaces_returned_for_venue() {
		String venueName = "Feisty Barrel Saloon";
		AvailableSpacesPage availableSpaces = venuePage.clickVenueLink(venueName).enterAttendees("10")
						.enterStartDate("11/12/2019").enterNumberOfDays("2")
						.submitForm();
		
		String headerText = availableSpaces.getPageHeader();
		Assert.assertEquals("Available Spaces at Feisty Barrel Saloon", headerText);
		Assert.assertEquals(5, availableSpaces.getNumberOfAvailableSpaces());
	}
}
