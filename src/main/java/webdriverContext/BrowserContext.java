package webdriverContext;

import java.io.File;
import java.io.IOException;

// import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author demian
 */
public class BrowserContext
{
	protected WebDriver driver;
	protected ConfigProperties generalProperties;
	protected WebDriverWait webDriverWait;

	public BrowserContext(BrowserType browserType) throws IOException, Exception
	{
		try
		{
			// log.debug("Start. Creation of the browers object");
			this.generalProperties = new ConfigProperties();
			if (browserType.equals(BrowserType.Firefox))
			{
				// String PROXY = "proxymaja.grupodelaware.com:8080";
				Proxy proxy = new Proxy();
				proxy.setProxyType(ProxyType.SYSTEM);
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setCapability(CapabilityType.PROXY, proxy);
				// driver = new AzulFirefoxDriver(cap);
				File file = new File("/firebug-1.10.6-fx.xpi");
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setEnableNativeEvents(true);
				// firefoxProfile.addExtension(file);
				// firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.10.6-fx"); // Avoid startup screen
				// WebDriver driver = new FirefoxDriver(firefoxProfile);
				// FirefoxBinary binary = new FirefoxBinary(new File("C:/Archivos de programa/Mozilla Firefox/firefox.exe"));
				this.driver = new FirefoxDriver(new FirefoxBinary(), firefoxProfile, cap);
				// driver = new FirefoxDriver(cap);
			}
			else if (browserType.equals(BrowserType.Chrome))
			{
				// ejecutable driver path
				String operatingSystem = System.getProperty("os.name");
				String Path;
				if (operatingSystem.equals("Linux"))
				{
					Path = System.getProperty("user.dir") + "/build/" + "chromedriver";
				}
				else
				{
					Path = System.getProperty("user.dir") + "\\build\\" + "chromedriver.exe";
				}
				System.setProperty("webdriver.chrome.driver", Path);
				this.driver = new ChromeDriver();
			}
			else if (browserType.equals(BrowserType.IE))
			{
				// String path = generalProperties.ie32DriverPath;
				//
				// // Javascript scripts to execute
				// // javaSciptOne=generalProperties.getProperty("javascript1");
				// // javaScriptTwo=generalProperties.getProperty("javascript2");
				// // javaScriptThree=generalProperties.getProperty("javascript3");
				//
				// File file = new File(path);
				// System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				// DesiredCapabilities iecap = DesiredCapabilities.internetExplorer();
				// // iecap.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
				//
				// driver = new InternetExplorerDriver(iecap);
			}
			else if (browserType.equals(BrowserType.Safari))
			{
				this.driver = new SafariDriver();
			}
			// log.debug("End. Creation of the browers object");
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public void delay(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}

	public ConfigProperties getPropertiesFile()
	{
		return this.generalProperties;
	}

	public WebDriverWait getwebDriverWait()
	{
		return this.webDriverWait;
	}

	public void init(String strStartURL)
	{
		this.driver.get(strStartURL);
		this.driver.manage().window().maximize();
		this.delay(1000);
	}

	// protected void delay()
	// {
	// try
	// {
	// Thread.sleep(generalProperties.getDelayMillisBetweenCalls());
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
	public void launchInitJavaScripts(String strPageName)
	{
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		if (strPageName.equalsIgnoreCase("page1"))
		{
			// js.executeScript(generalProperties.getProperty("javascript1"));
			// js.executeScript(generalProperties.getProperty("javascript2"));
			// js.executeScript(generalProperties.getProperty("javascript3"));
			// js.executeScript(generalProperties.getProperty("javascript4"));
		}
		if (strPageName.equalsIgnoreCase("page2"))
		{
			// js.executeScript(generalProperties.getProperty("javascript1"));
		}
	}

	public void setPropertiesFile(ConfigProperties propertiesFile)
	{
		this.generalProperties = propertiesFile;
	}
}
