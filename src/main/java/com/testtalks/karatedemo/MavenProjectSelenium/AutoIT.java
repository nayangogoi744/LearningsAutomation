package com.testtalks.karatedemo.MavenProjectSelenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		   WebDriverManager.chromedriver().setup();
		   //System.setProperty("webdriver.gecko.driver","C:\\Old-data\\programming\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		   //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C://Users//njy//Desktop//ccc.txt");
	       WebDriver driver = new ChromeDriver();
	       driver.get("file:///C://Users//njy//Desktop//fileupload.html");
	       
	       driver.findElement(By.xpath("//*[@id='1']")).click();
	       
	       Thread.sleep(10000);
	       Runtime.getRuntime().exec("C:\\Users\\njy\\Desktop\\autoid\\Fileupload.exe");
	       
	       driver.quit();
	       
	}

}
