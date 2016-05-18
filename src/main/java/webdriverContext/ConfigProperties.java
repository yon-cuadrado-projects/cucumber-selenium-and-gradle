package webdriverContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties
{

	// New Properties
	protected String amarisUrl;

	// protected long delayMillis;
	// protected long delayMillisBetweenCalls;
	public Properties generalProperties;
	// protected String urlbase;
	// protected String urlOffer;
	// protected String urltest;
	// protected String ie32DriverPath;
	// protected String ie64DriverPath;
	// protected String chrome_32_linux_DriverPath;
	// protected String chrome_64_linux_Driverpath;
	protected String chrome_32_windows_Driverpath;

	// New Properties
	public void setAmarisUrl(String amarisUrl)
	{
		this.amarisUrl = amarisUrl;
	}

	public String getAmarisUrl()
	{
		return this.amarisUrl;
	}

	// public void setChrome_32_linux_DriverPath(String chrome_32_linux_DriverPath)
	// {
	// this.chrome_32_linux_DriverPath = chrome_32_linux_DriverPath;
	// }
	//
	// public void setChrome_64_linux_Driverpath(String chrome_64_linux_Driverpath)
	// {
	// this.chrome_64_linux_Driverpath = chrome_64_linux_Driverpath;
	// }

	public void setChrome_32_windows_Driverpath(String chrome_32_windows_Driverpath)
	{
		this.chrome_32_windows_Driverpath = chrome_32_windows_Driverpath;
	}

	// public String getChrome_32_linux_DriverPath()
	// {
	// return chrome_32_linux_DriverPath;
	// }
	//
	// public String getChrome_64_linux_Driverpath()
	// {
	// return chrome_64_linux_Driverpath;
	// }

	public String getChrome_32_windows_Driverpath()
	{
		return chrome_32_windows_Driverpath;
	}

	// public long getDelayMillisBetweenCalls()
	// {
	// return delayMillisBetweenCalls;
	// }
	//
	// public void setDelayMillisBetweenCalls(long delayMillisBetweenCalls)
	// {
	// this.delayMillisBetweenCalls = delayMillisBetweenCalls;
	// }
	//
	// public long getDelayMillis()
	// {
	// return delayMillis;
	// }
	//
	// public void setIe32DriverPath(String ie32DriverPath)
	// {
	// this.ie32DriverPath = ie32DriverPath;
	// }
	//
	// public void setIe64DriverPath(String ie64DriverPath)
	// {
	// this.ie64DriverPath = ie64DriverPath;
	// }
	//
	// public String getIe32DriverPath()
	// {
	// return ie32DriverPath;
	// }
	//
	// public String getIe64DriverPath()
	// {
	// return ie64DriverPath;
	// }
	//
	// public void setDelayMillis(long delayMillis)
	// {
	// this.delayMillis = delayMillis;
	// }
	//
	// public String getUrltest()
	// {
	// return urltest;
	// }
	//
	// public void setUrltest(String urltest)
	// {
	// this.urltest = urltest;
	// }
	//
	// public String getUrlbase()
	// {
	// return urlbase;
	// }
	//
	// public void setUrlbase(String urlbase)
	// {
	// this.urlbase = urlbase;
	// }
	//
	// public String getUrlOffer()
	// {
	// return urlOffer;
	// }
	//
	// public void setUrlOffer(String urlOffer)
	// {
	// this.urlOffer = urlOffer;
	// }

	public ConfigProperties() throws IOException
	{
		// Read general properties
		generalProperties = new Properties();
		// generalProperties.load(new FileInputStream(propertiesFile));

		// InputStream in = FFTestObject.class.getClassLoader().getResourceAsStream(propertiesFile);
		InputStream in = getClass().getResourceAsStream("/config.properties");
		generalProperties.load(in);

		// Properties configured test url
		// urltest = generalProperties.getProperty("url.test");
		// urlbase = generalProperties.getProperty("url.base");
		// urlOffer = generalProperties.getProperty("url.offer");
		//
		// // Waiting millis
		// delayMillis = Long.valueOf(generalProperties.getProperty("delayMilliSecs")).longValue();
		//
		// // Waiting millis
		// delayMillisBetweenCalls = Long.valueOf(generalProperties.getProperty("delayMilliSecsBetweenCalls")).longValue();
		//
		// // iedriver paths
		// ie32DriverPath = generalProperties.getProperty("ie32DriverPath");
		// ie64DriverPath = generalProperties.getProperty("ie64DriverPath");
		//
		// // chrome driver paths
		// chrome_32_linux_DriverPath = generalProperties.getProperty("chrome32_linux_path");
		// chrome_64_linux_Driverpath = generalProperties.getProperty("chrome64_linux_path");
		this.chrome_32_windows_Driverpath = generalProperties.getProperty("chrome32DriverPath");
		this.amarisUrl = generalProperties.getProperty("amarisHome");

	}
}
