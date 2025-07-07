package com.demo.sauce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.sauce.pageObjects.CartPage;
import com.demo.sauce.pageObjects.CheckoutOverviewPage;
import com.demo.sauce.pageObjects.CheckoutPage;
import com.demo.sauce.pageObjects.FinishOrderPage;
import com.demo.sauce.pageObjects.LoginPage;
import com.demo.sauce.pageObjects.ProductPage;
import com.demo.sauce.testBase.BaseClass;

public class TransactionTest extends BaseClass{
	
	ProductPage pp;
	CartPage cp;
	
	void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(property.getProperty("username"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
	}
	
	@Test(priority = 1, description = "TC003")
	void verifyProduct() {
		try {
			setupLogin();
			pp = new ProductPage(driver);
			pp.scrollToMiddle();
			Assert.assertEquals(pp.sizeProduct(), 6);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "verifyProduct", description = "TC004")
	void addToCart() {
		try {
			pp = new ProductPage(driver);
			pp.addToCart();
			pp.scrollToUp();
			pp.goToCart();
			cp = new CartPage(driver);
			Assert.assertTrue(cp.sizeCarts() > 0);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "addToCart", description = "TC005")
	void checkOut() {
		try {
			cp= new CartPage(driver);
			cp.clickCheckout();
			pp = new ProductPage(driver);
			CheckoutPage chp = new CheckoutPage(driver);
			chp.setFirstName(property.getProperty("firstname"));
			chp.setLastName(property.getProperty("lastname"));
			chp.setPostalCode(property.getProperty("postalCode"));
			chp.clickContinue();
			CheckoutOverviewPage cop=new CheckoutOverviewPage(driver);
			
			Assert.assertTrue(cop.sizeCarts() > 0);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods = "checkOut", description = "TC006")
	void checkFinishOrder() {
		CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);
		cop.scrollToSummaryLabel();
		cop.clickFinish();
		
		FinishOrderPage fop = new FinishOrderPage(driver);
		
		Assert.assertEquals(fop.headerTextComplete(), "THANK YOU FOR YOUR ORDER");
	}
	
	
	
}
