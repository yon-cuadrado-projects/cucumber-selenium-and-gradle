package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ApplyPage
{
	WebDriver driver;

	@FindBy(xpath = ".//select[@name='title']")
	private WebElement titleWebElement;
	public Select titleSelect;

	@FindBy(name = "dateBirth")
	public WebElement dateOfBirth;

	@FindBy(name = "country")
	private WebElement countryWebElement;
	public Select countrySelect;

	public ApplyPage(WebDriver webDriver)
	{
		this.driver = webDriver;
	}

	public Select getTitle()
	{
		if (this.titleSelect == null)
		{
			this.titleSelect = new Select(this.titleWebElement);
			return titleSelect;
		}
		else
		{
			return titleSelect;
		}
	}

	public Select getCountry()
	{
		if (this.countrySelect == null)
		{
			this.countrySelect = new Select(this.countryWebElement);
			return countrySelect;
		}
		else
		{
			return countrySelect;
		}
	}
}
