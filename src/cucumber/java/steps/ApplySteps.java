package steps;

import org.openqa.selenium.support.PageFactory;

import Pages.ApplyPage;
import Pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webdriverContext.BrowserContext;
import webdriverContext.BrowserType;
import webdriverContext.ConfigProperties;

public class ApplySteps
{
	ConfigProperties properties;
	private BrowserContext br;

	@Given("^I navigate to the amaris web page$")
	public void i_navigate_to_the_amaris_web_page() throws Throwable
	{
		ConfigProperties properties = new ConfigProperties();
		br = new BrowserContext(BrowserType.Chrome);

		br.init(properties.getAmarisUrl());
	}

	@When("^I click on the apply button$")
	public void i_click_on_the_apply_button() throws Throwable
	{
		HomePage homePage = PageFactory.initElements(br.getDriver(), HomePage.class);
		homePage.apply1.click();
	}

	@Then("^The apply page has to be loaded correctly$")
	public void the_apply_page_has_to_be_loaded_correctly() throws Throwable
	{
		ApplyPage ap = PageFactory.initElements(br.getDriver(), ApplyPage.class);
		// ap.InitializeSelects();
		ap.getTitle().selectByVisibleText("Mrs");
		ap.dateOfBirth.sendKeys("19/08/1996");
		ap.getCountry().selectByVisibleText("Ireland");
		br.getDriver().quit();
	}

	@Given("^I want to write a step with (.*)$")
	public void i_want_to_write_a_step_with_name(int arg1) throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I check for the (.*) in step$")
	public void i_check_for_the_in_step(int arg1) throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I verify the (.*) in step$")
	public void i_verify_the_success_in_step() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
