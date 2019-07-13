package com.testtalks.karatedemo.MavenProjectSelenium;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
	    
	  
	    /*WebElement el = driver.findElement(By.xpath("//p[text()='WebDriver']"));
	    
	    boolean b = el.isDisplayed();
	    if(b){
	    	System.out.println("Able to find the link");
	    }else{
	    	System.out.println("Unable to find the link");
	    }
	*/
	    
	    
	 // Waiting 30 seconds for an element to be present on the page, checking
	    // for its presence once every 5 seconds.
	    Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
	        .withTimeout(30, TimeUnit.SECONDS)
	        .pollingEvery(5, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class);

	    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	    	  WebElement element = driver.findElement(By.xpath("//*[@id='demo']"));
	    	  
	    	  String str = element.getAttribute("innerHTML");
	    	  if(str.equalsIgnoreCase("WebDriver")){
	    		  
	    		  return element;
	    	  }else{
	    		  System.out.println("Elements :" +str);
	    		  return null;
	    	  }
	    	  	 
	      }
	    });
	    
	    
	    System.out.println("Element is Displayed :" +element.isDisplayed());
	}

}
