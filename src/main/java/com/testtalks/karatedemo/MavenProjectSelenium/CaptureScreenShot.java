package com.testtalks.karatedemo.MavenProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.Utility;

public class CaptureScreenShot{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.facebook.com");
	    Utility.captureScreenShot(driver, "browserstarted");
	    driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Learn");
	    Utility.captureScreenShot(driver,"typedusername");
	    
	    driver.quit();
	   
	    
	}

}
