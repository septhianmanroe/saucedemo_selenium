package com.demo.sauce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstNameField;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastNameField;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCodeField;
	
	@FindBy(xpath = "//input[@value='CONTINUE']")
	WebElement btnContinue;
	
	public void setFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void setPostalCode(String postalCode) {
		postalCodeField.sendKeys(postalCode);
	}

	public void clickContinue() {
		btnContinue.click();
	}
}
