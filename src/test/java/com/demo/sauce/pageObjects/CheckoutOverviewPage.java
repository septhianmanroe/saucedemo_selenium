package com.demo.sauce.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage{
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='cart_list']//div[@class='cart_item']")
	List<WebElement> carts;
	
	@FindBy(xpath = "//div[normalize-space()='FREE PONY EXPRESS DELIVERY!']")
	WebElement summaryLabel;
	
	@FindBy(xpath = "//a[normalize-space()='FINISH']")
	WebElement btnFinish;
	
	public int sizeCarts() {
		return carts.size();
	}
	
	public void scrollToSummaryLabel() {
		scrollToElement(summaryLabel);
	}
	
	public void clickFinish() {
		btnFinish.click();
	}

}
