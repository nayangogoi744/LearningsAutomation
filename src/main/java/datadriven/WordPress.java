package datadriven;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.Utility;

public class WordPress {
	
	WebDriver driver;
	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
    Date date;
	
	@Test(dataProvider="providelogininfo")
	public void login(String username,String password) throws InterruptedException{
		   WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	       driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
	       driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
	       driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
	       driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
	       Thread.sleep(2000);
	       //System.out.println(driver.getTitle());
	       String title = driver.getTitle();
	      
	     //  Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Unable to login using the provided info");
	       Assert.assertEquals("Dashboard ‹ opensourcecms — WordPress", title);	       
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
