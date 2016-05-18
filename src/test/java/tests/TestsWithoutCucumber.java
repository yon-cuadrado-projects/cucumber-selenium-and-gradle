package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Pages.ApplyPage;
import Pages.HomePage;
import webdriverContext.BrowserContext;
import webdriverContext.BrowserType;
import webdriverContext.ConfigProperties;

public class TestsWithoutCucumber
{
	private BrowserContext br;
	// BeginNewTest

	@AfterTest
	public void CloseBrowser()
	{
		this.br.getDriver().close();
	}

	@Test
	public void OpenApplyLink() throws Exception
	{
		ConfigProperties properties = new ConfigProperties();
		this.br = new BrowserContext(BrowserType.Chrome);
		this.br.init(properties.getAmarisUrl());
		HomePage homePage = PageFactory.initElements(this.br.getDriver(), HomePage.class);
		homePage.apply1.click();
		ApplyPage ap = PageFactory.initElements(this.br.getDriver(), ApplyPage.class);
		// ap.InitializeSelects();
		ap.getTitle().selectByVisibleText("Mrs");
		ap.dateOfBirth.sendKeys("19/08/1996");
		ap.getCountry().selectByVisibleText("Ireland");
		Assert.assertEquals("Ireland", ap.countrySelect.getFirstSelectedOption().getText());
	}
	// EndNewTest
}
