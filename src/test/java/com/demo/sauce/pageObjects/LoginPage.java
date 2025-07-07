package com.demo.sauce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
	
  public LoginPage(WebDriver driver) {
	  super(driver);
  }
  
  @FindBy(xpath = "//input[@id='user-name']")
  WebElement usernameField;
  
  @FindBy(xpath = "//input[@id='password']")
  WebElement passwordField;
  
  @FindBy(xpath = "//input[@id='login-button']")
  WebElement btnLogin;
  
  @FindBy(xpath = "//h3[@data-test='error']")
  WebElement errorElement;
  
  public void setUsername(String username) {
	  usernameField.sendKeys(username);
  }
  
  public void setPassword(String password) {
	  passwordField.sendKeys(password);
  }
  
  public void clickLogin() {
	  btnLogin.click();
  }
  
  public String getErrorMessage() {
	  return errorElement.getText();
  }
}
