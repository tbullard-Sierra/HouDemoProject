package com.qa.houpermitproject.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttachmentFile {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		
		driver.get("https://houstontx-tst.rhythmlabs.infor.com/");
		
		driver.findElement(By.xpath("//input[@id='username_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']")).sendKeys("m.nath@sierradigitalinc.com");
		
		//input[contains(@id,'username_rhythmcivicsLoginportlet_INSTANCE')]
		driver.findElement(By.xpath("//input[@id='password_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_']")).sendKeys("Sierra@2023");
		
		driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
		
		String atfile="MECS2677";
//Scroll Down	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,400)","");
//Clicking Login button		
		//WebElement login=driver.findElement(By.cssSelector("button.btn btn-primary login-submit"));
		driver.findElement(By.cssSelector("button#login_submit_rhythmcivicsLoginportlet_INSTANCE_9lZ2jEEWuRHK_")).click();		
				
//Clicking in my dashboard	
		driver.findElement(By.cssSelector("a[href='https://houstontx-tst.rhythmlabs.infor.com/my-dashboard']")).click();
		Thread.sleep(5000);
						
		driver.findElement(By.xpath("//div[@class='summary-card']//div[@class='default-value-class']//a[@id='ItemLink_"+atfile+"']")).click();
		Thread.sleep(2000);
		
		//Clicking on the down arrow button
		//WebElement drop=driver.findElement(By.xpath("//div[@class='content-box attachment-box new-attachment-box collapsible']//button[@aria-label='Hide/Show attachment details']"));
		
//		Actions act=new Actions(driver);
//		act.click(drop).build().perform();
//		Thread.sleep(5000);

		
		WebElement hid=driver.findElement(By.xpath("//div[@class='collapsible-content expanded']//div[@class='list-region ']//button[@id='new-attachment-group-add']"));
		js.executeScript("arguments[0].click()", hid);
		Thread.sleep(3000);
		
		/*driver.findElement(By.xpath("//div[@class='list-region ']//div[@class='label-region']//button[@id='new-attachment-group-add']")).click();
		Thread.sleep(5000);*/
		
		//Upload Attachment text getting
		WebElement upload=driver.findElement(By.xpath("//h2[@id='add-attachment-title']"));
		System.out.println(upload.getText());
		Thread.sleep(2000);
		
		WebElement button=driver.findElement(By.xpath("//button[@id='new-attachment-browse-link']"));
		button.click();
		
		String expectedtitle="Upload Attachments";
		String actualtitle=upload.getText();
		
		Assert.assertEquals(expectedtitle, actualtitle);
		
		StringSelection sel=new StringSelection("C:\\Users\\m.nath@sierradigitalinc.com\\Desktop\\apple-event-page.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		
		
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		/*try {
			Runtime.getRuntime().exec("C://Users//k.rajendran//Desktop//FileUpload.exe"+""+"C:\\Users\\k.rajendran\\Desktop\\landscape-macbook-6016x3384-10760.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//WebElement sel1=driver.findElement(By.xpath("//input[@id='document-type-0']"));
		WebElement sel1=driver.findElement(By.xpath("//input[@placeholder='Select']"));
		sel1.click();
		sel1.sendKeys("Notarized Application Acknowledgement");
		
		driver.findElement(By.xpath("//button[@id='newAttachment-saveModalBtn']")).click();
		
	

		
		
		
		
		
	}

}
