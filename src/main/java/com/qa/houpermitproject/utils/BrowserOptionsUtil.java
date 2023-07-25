package com.qa.houpermitproject.utils;

import java.util.Properties;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptionsUtil {

	
	ChromeOptions co;
	FirefoxOptions fo;
	EdgeOptions eo;
	SafariOptions so;
	
	Properties prop;
	
	public BrowserOptionsUtil(Properties prop) {
		
		this.prop = prop;
	}
	
	public ChromeOptions getChromeOptions() {
		
		co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
		co.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			
			fo.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("--incognito");
		}
		
		return fo;
	}
	
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eo.addArguments("--incognito");
		}
		
		return eo;
	}
	
	
	
	
	
	
}
