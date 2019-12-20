package com.techelevator.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AvailableSpacesPage {

	private WebDriver webDriver;
	
	public AvailableSpacesPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String getPageHeader() {
		WebElement h1 = webDriver.findElement(By.tagName("h1"));
		return h1.getText();
	}
	
	public int getNumberOfAvailableSpaces() {
		List<WebElement> rows = webDriver.findElements(By.tagName("tr"));
		return rows.size() - 1;
	}
}
