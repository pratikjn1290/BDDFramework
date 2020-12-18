package com.product.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

//Locators
	private By email_id = By.xpath("//input[@id = 'email']");
	private By password = By.xpath("//input[@id = 'passwd']");
	private By signInButton = By.xpath("//input[@id = 'SubmitLogin']");
	private By forgotPassword = By.linkText("Forgot your password?");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean getForgotPasswordLink() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void entrerUsername(String username) {
		driver.findElement(email_id).sendKeys(username);
	}

	public void enterPassword(String pword) {
		driver.findElement(password).sendKeys(pword);
	}

	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}

}
