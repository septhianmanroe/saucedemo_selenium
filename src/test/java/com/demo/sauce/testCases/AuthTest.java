package com.demo.sauce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.sauce.pageObjects.LoginPage;
import com.demo.sauce.pageObjects.ProductPage;
import com.demo.sauce.testBase.BaseClass;

public class AuthTest extends BaseClass {
	@Test(priority = 1, description = "TC001")
	void verifyLogin() {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(property.getProperty("username"));
			lp.setPassword(property.getProperty("password"));
			lp.clickLogin();
			
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority = 2, description = "TC007")
	void verifyLogout(){
		try {
			ProductPage pp = new ProductPage(driver);
			pp.openSidebar();
			pp.clickLogout();
			
			Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority = 3, description = "TC002")
	void verifyLoginNegative() {
		try {
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(property.getProperty("username")+"failed");
			lp.setPassword(property.getProperty("password"));
			lp.clickLogin();
						
			Assert.assertEquals(lp.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
