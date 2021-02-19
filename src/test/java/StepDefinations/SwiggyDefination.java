package StepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwiggyDefination {

	@Given("^valid registered mobile number$")
	public void valid_registered_mobile_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("valid registered mobile number");
	}

	@Given("^state of number \\(registered/not registered\\)$")
	public void state_of_number_registered_not_registered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("state of number (registered/not registered)");
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Login page");
	}

	@When("^I enter mobile number$")
	public void i_enter_mobile_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Enter mobile number");
	}

	@When("^click for log in$")
	public void click_for_log_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Click log in");
	}

	@Then("^I validate the number$")
	public void i_validate_the_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Check the valid number");
	}

	@Then("^display otp textbox$")
	public void display_otp_textbox() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Number is registered so log in activity continues");
	}

	@Given("^valid not registered mobile number$")
	public void valid_not_registered_mobile_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Enter valid not registered mobile number");
	}

	@Then("^display sign up page for registration of number$")
	public void display_sign_up_page_for_registration_of_number() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Number is not registered so sign up page is displayed");
	}

}
