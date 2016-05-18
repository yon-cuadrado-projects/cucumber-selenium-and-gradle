package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage
{
	public WebDriver webdriver;

	@FindBy(name = "searchFieldName")
	public WebElement searchField;

	@FindBy(xpath = "//*[contains(text(), 'Apply')]")

	public WebElement apply;

	@FindBy(xpath = "//*[translate(normalize-space(text()),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')='APPLY']")
	public WebElement apply1;

	public HomePage(WebDriver webdriver)
	{
		this.webdriver = webdriver;
	}
}
