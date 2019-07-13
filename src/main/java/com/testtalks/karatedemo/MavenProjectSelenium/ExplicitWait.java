package com.testtalks.karatedemo.MavenProjectSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
	    
	    WebDriverWait wait =  new WebDriverWait(driver, 30);
	    
	    WebElement ele =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
	    //WebElement el = driver.findElement(By.xpath("//p[text()='WebDriver']"));
	    
	    boolean b = ele.isDisplayed();
	    if(b){
	    	System.out.println("Able to find the link");
	    }else{
	    	System.out.println("Unable to find the link");
	    }
	
	}

}
