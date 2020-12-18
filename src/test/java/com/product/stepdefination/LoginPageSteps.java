package com.product.stepdefination;

import org.junit.Assert;

import com.product.factory.BrowserFactory;
import com.product.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(BrowserFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		BrowserFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {

		String title = loginPage.getLoginPageTitle();
		System.out.println("Title of the page" + title);

	}

	@Then("page title should display {string}")
	public void login_page_title_should_be_displayed(String expectedTitleName) {

		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot password link should display")
	public void forgot_password_link_should_display() {
		Assert.assertTrue(loginPage.getForgotPasswordLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String uname) {
		loginPage.entrerUsername(uname);
	}

	@When("user enteres password {string}")
	public void user_enteres_password(String pword) {
		loginPage.enterPassword(pword);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickSignIn();
	}

}
