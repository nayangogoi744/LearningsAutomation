package com.testtalks.karatedemo.MavenProjectSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicRadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	   List<WebElement> buttons = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
	   
	   for(int i=0;i<buttons.size();i++){
		  WebElement checkbox =  buttons.get(i);
		  String str = checkbox.getAttribute("value");
		  if(str.equalsIgnoreCase("C#")){
			  checkbox.click();
			  break;
		  }
	   }
	       

	}

}
