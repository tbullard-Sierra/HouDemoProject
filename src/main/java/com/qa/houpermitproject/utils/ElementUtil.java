package com.qa.houpermitproject.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.houpermitproject.base.BasePage;

public class ElementUtil {
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if(Boolean.parseBoolean(BasePage.flashElement)) flash(element);
		return element;
	}
	
//	public WebElement getElement(By locator) {
//		
//		WebElement element = driver.findElement(locator);
//		
//		return element;
//	}
	
	public void doSendKeys(By locator,String value) {
		
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String doGetText(By locator) {
		
		return getElement(locator).getText();
	}
	
public boolean isDisplayed(By locator) {
		
		return getElement(locator).isDisplayed();
	}
	
public void selectValueFromDropdown(By locator, String value) {
		
		List<WebElement> countryList = driver.findElements(locator);
		
		for (WebElement ele : countryList) {
			
			String text = ele.getText();
			//System.out.println(text);
			
			if(text.equals(value)) {
				
				ele.click();
				break;
			}
		}
		
		
	}
	
	
	
	
	
	
	//*******************************Java Script Utils*******************************
	
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}
	
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollPageUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
//	public void flash(WebElement element) {
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		String bgcolor = element.getCssValue("backgroundColor");
//		for (int i = 0; i < 15; i++) {
//			changeColor("rgb(0,200,0)", element);// 1
//			changeColor(bgcolor, element);// 2
//		}
//	}

//	private void changeColor(String color, WebElement element) {
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
//		js.executeScript("arguments[0].style.border='2px solid red'", element);
//
//		try {
//			Thread.sleep(20);
//		} catch (InterruptedException e) {
//		}
//	}
	
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 15; i++) {
			changeColor(element);// 1
			changeColor(element);// 2
		}
	}
	private void changeColor(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		//js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		js.executeScript("arguments[0].style.border='2px solid red'", element);
		//js.executeScript("arguments[0].style.background='yellow'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	//*********************Wait Utils****************************
	
		public List<WebElement> visibilityOfAllElements(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}

		public void getPageLinksText(By locator, int timeOut) {
			visibilityOfAllElements(locator,timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
			
		}

		
		/**
		 * 
		 * @param locator
		 * @param timeOutSecs
		 * @return
		 */
		public WebElement waitForElementPresent(By locator,int timeOutSecs) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSecs));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		}
		
		public WebElement waitForElementToBeVisible(By locator,int timeOutSecs) {
			WebElement element = getElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSecs));
			return wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		
		public String waitForTitle(String title, int timeOutSecs) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSecs));
			wait.until(ExpectedConditions.titleIs(title));
			return driver.getTitle();
		}
		
		public  boolean WaitForURL(String url, int timeOut) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.urlContains(url));
		}
		
		public Alert waitForAlertToBePresent(int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public WebElement waitForElementToBeClickable(By locator,int timeOut) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		
		public void clickWhenReady(By locator, int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			WebElement element =wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
		
		public WebElement waitForElementWithFulentWait(By locator, int timeOut, int interval) {
			
			Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(interval))
					.ignoring(NoSuchElementException.class); 
					// we can send multiple exceptions by cama separator
					//.ignoring(NoSuchElementException.class, NullPointerException.class);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		}
	
	
	
	
	
	
}
