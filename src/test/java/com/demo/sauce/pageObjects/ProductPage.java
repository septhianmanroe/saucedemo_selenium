package com.demo.sauce.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//button[normalize-space()='Open Menu']")
	WebElement sideBtn;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> listProduct;
	
	@FindBy(xpath = "//div[@class='inventory_item'][1]//button[@class='btn_primary btn_inventory']")
	WebElement firstItemAddToCart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
	WebElement cartBtn;
	
	public void openSidebar() {
		sideBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
	
	public int sizeProduct() {
		return listProduct.size();
	}
	
	public void addToCart() {
		firstItemAddToCart.click();
	}
	
	public void goToCart() {
		cartBtn.click();
	}
	
	public void scrollToMiddle() {
		scrollToPixel(0, 300);
	}
	public void scrollToUp() {
		scrollToPixel(0, 0);
	}
	
	
	
}
