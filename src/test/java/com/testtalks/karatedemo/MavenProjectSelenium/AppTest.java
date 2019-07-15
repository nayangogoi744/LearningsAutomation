package com.testtalks.karatedemo.MavenProjectSelenium;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.Utility;

public class AppTest {
	
	WebDriver driver;
	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
    Date date;
	
	@Test(dataProvider="providelogininfo")
	public void login(String username,String password) throws InterruptedException, MalformedURLException{
		//String exePath = "C:\\Old-data\\programming\\chromedriver_win32-75\\chromedriver.exe";
	//	System.setProperty("webdriver.chrome.driver", exePath);
		 WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		//disable automation info bar
		//options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		driver =  new ChromeDriver(options);
	       
		   //WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), DesiredCapabilities.chrome());
		   //WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), DesiredCapabilities.chrome());
	       driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
	       driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
	       driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
	       driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	       Thread.sleep(2000);
	       //System.out.println(driver.getTitle());
	       boolean title = driver.getTitle().contains("Dashboard");
	     
	      
	     //  Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Unable to login using the provided info");
	       //Assert.assertEquals("Dashboard ‹ opensourcecms — WordPress", title);	  
	       Assert.assertTrue(title);
	       System.out.println("Successfully login");
	      
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult){
		
		
		if(testResult.getStatus()==ITestResult.FAILURE){
			date = new Date();
			Utility.captureScreenShot(driver, dateFormat.format(date)+testResult.getName());
		}
		 driver.quit();
	}
	
	@DataProvider(name="providelogininfo")
	public Object[][] test(){
		
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "demo";
		data[1][0] = "opensourcecms";
		data[1][1] = "opensourcecms";
		data[2][0] = "admin";
		data[2][1] = "demo";
		
		return data;
		
	}

}
