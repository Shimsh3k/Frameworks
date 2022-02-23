package com.mycompany.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;




public class Browser 
{
	public static WebDriver createDriver(String browser) throws MalformedURLException
	{
		WebDriver driver=null;
		
		
		if(browser.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty("webdriver.gecko.driver","Util\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			// WebDriver is an interface
			// driver is a reference variable 
			// FirefoxDriver() is a Constructor 
			// "new" is a keyword 
			// new FirefoxDriver() is an Object.
			
		}
		
		else if(browser.equalsIgnoreCase("RemoteChrome"))
		{
			
			driver = new RemoteWebDriver(new URL("http://10.10.19.49:4444/wd/hub"), DesiredCapabilities.chrome());
		}

		
		else if(browser.equalsIgnoreCase("ChromeLocal"))
		{
			System.setProperty("webdriver.chrome.driver","Util\\chromedriver.exe");
			driver = new ChromeDriver();
					
		}
		
		else if(browser.equalsIgnoreCase("ChromeHeadLess"))
		{
			System.setProperty("webdriver.chrome.driver","Util\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			
			driver = new ChromeDriver(options);
			
			
		}
		
		else if(browser.equalsIgnoreCase("Chrome"))
		{

			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().version("74.0.3729.6").forceDownload().setup();
			driver = new ChromeDriver();
            EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
            edriver.manage().window().maximize();
            edriver.manage().deleteAllCookies();
			edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			edriver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);
			java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
			java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

             driver = edriver;
             System.out.println("======Chrome Launched=========");
		}
		
		
		
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			throw new InvalidParameterException(browser + " - is not a valid web browser for web driver.");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public static void quitDriver(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

} 
		
