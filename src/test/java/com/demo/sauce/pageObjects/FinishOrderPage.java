package com.demo.sauce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishOrderPage extends BasePage{
	
	public FinishOrderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement headerComplete;
	
	public  String headerTextComplete() {
		return headerComplete.getText();
	}

}
