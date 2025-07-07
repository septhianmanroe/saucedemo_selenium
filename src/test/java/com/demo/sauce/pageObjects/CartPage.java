package com.demo.sauce.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='cart_item']")
	List<WebElement> carts;
	
	@FindBy(xpath = "//a[normalize-space()='CHECKOUT']")
	WebElement btnCheckout;
	
	public int sizeCarts() {
		return carts.size();
	}
	
	public void clickCheckout() {
		btnCheckout.click();
	}

}
