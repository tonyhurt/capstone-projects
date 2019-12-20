package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckReservationPage {

	private WebDriver webDriver;
	
	public CheckReservationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public CheckReservationPage enterAttendees(String number) {
		WebElement field = webDriver.findElement((By.name("attendees")));
		field.sendKeys(number);
		return this;
	}
	
	public CheckReservationPage enterStartDate(String date) {
		WebElement field = webDriver.findElement(By.name("startDate"));
		field.sendKeys(date);
		return this;
	}
	
	public CheckReservationPage enterNumberOfDays(String duration) {
		WebElement field = webDriver.findElement(By.name("duration"));
		field.sendKeys(duration);
		return this;
	}
	
	public AvailableSpacesPage submitForm() {
		WebElement button = webDriver.findElement(By.xpath("/html/body/div[2]/form/button"));
		button.click();
		return new AvailableSpacesPage(webDriver);
	}
}
