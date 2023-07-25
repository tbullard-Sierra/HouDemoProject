package com.qa.houpermitproject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.houpermitproject.utils.BrowserOptionsUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	
	//we maintain methods to initialize webdriver , read the properties for config file and to capture the screenshot
	WebDriver driver;
	Properties prop;
	BrowserOptionsUtil brOpts;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public static String flashElement;
	
	public WebDriver initialize_WebDriver(Properties prop) {
		
		
		flashElement = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name: "+browserName);
		brOpts = new BrowserOptionsUtil(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			if(Boolean.parseBoolean(prop.getProperty("remote").trim())) {
				initialize_RemoteWebDriver(browserName);
			}else {
				tlDriver.set(new ChromeDriver(brOpts.getChromeOptions()));
			}
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			if(Boolean.parseBoolean(prop.getProperty("remote").trim())) {
				initialize_RemoteWebDriver(browserName);
			}else {
				tlDriver.set(new EdgeDriver(brOpts.getEdgeOptions()));
			}
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			if(Boolean.parseBoolean(prop.getProperty("remote"))) {
				initialize_RemoteWebDriver(browserName);
			}else {
				tlDriver.set(new FirefoxDriver(brOpts.getFirefoxOptions()));
			}
			
		}else {
			System.out.println("Please pass the correct browser name :"+browserName);
		}
		
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
//		
//		return driver;
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//getDriver().get(prop.getProperty("cohUrl").trim());
		//getDriver().get(prop.getProperty("url").trim());
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	private void initialize_RemoteWebDriver(String browserName) {
		
		System.out.println("Browser is: "+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			//DesiredCapabilities cap = new  DesiredCapabilities();
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			//cap.setCapability(ChromeOptions.CAPABILITY, brOpts.getChromeOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl").trim()),brOpts.getChromeOptions()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else if(browserName.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, brOpts.getFirefoxOptions());
			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl").trim()),cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Properties initialize_Properties() {
		
		String filePath = ".\\src\\main\\java\\com\\qa\\houpermitproject\\config\\qa_config.properties";
		prop = new Properties();
		
//		String envvironment = System.getProperty("env");
//		
//		switch (envvironment) {
//		case "dev":
//			filePath = "dev";
//			break;
//			
//		case "QA":
//			filePath ="qa";
//			break;
//		case "prod":
//			filePath="prod";
//			break;
//		default:
//			System.out.println("Please pass correct environment:"+envvironment);
//			break;
//		}
		try {
			FileInputStream fis= new FileInputStream(filePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return prop;
	}
	
	
	
	
	public String getScreehshot() {
		
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File  dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	
public String takesElementScreehshot(WebElement element) {
		
		File src = element.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File  dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	

	
	
	
	

}
