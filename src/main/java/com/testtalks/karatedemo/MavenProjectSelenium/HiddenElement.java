package com.testtalks.karatedemo.MavenProjectSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	       /*int x =driver.findElement(By.id("male")).getLocation().getX();
	       int y =driver.findElement(By.id("male")).getLocation().getY();
	       System.out.println("X cord " +x);
	       System.out.println("Y cord " +y);*/
	       List<WebElement> list = driver.findElements(By.xpath("//input[@id='male']"));
	       System.out.println("Total radio buton: "+list.size());
	       
	       for(int i=0;i<list.size();i++){
	    	  int x=list.get(i).getLocation().getX();
	    	  if(x!=0){
	    		  list.get(i).click();
	    		  break;
	    	  }
	       }
	       
	       
	}

}
