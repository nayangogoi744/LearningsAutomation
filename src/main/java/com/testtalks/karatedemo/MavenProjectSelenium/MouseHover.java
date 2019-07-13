package com.testtalks.karatedemo.MavenProjectSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
	    
	    Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//button[text()='Automation Tools']"))).perform();
	    List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-content']/a"));
	    
	    /*for(int i=0;i<list.size();i++){
	    	WebElement l = list.get(i);
	    	String s = l.getAttribute("innerHTML");
	    	System.out.println(s);
	    }*/
	    
	    for(WebElement el:list){
	    	String s = el.getAttribute("innerHTML");
	    	System.out.println(s);
	    	if(s.equals("Selenium")){
	    		el.click();
	    		break;
	    	}
	    }
	}

}
