package com.testtalks.karatedemo.MavenProjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import library.HighLight;

public class HighLighter {

	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://facebook.com");
	       WebElement username = driver.findElement(By.id("email"));
	       HighLight.highLightElement(driver, username);
	       username.sendKeys("nayangogoi@gmail.com");
	       
	       
	       WebElement password = driver.findElement(By.id("pass"));
	       HighLight.highLightElement(driver, password);
	       password.sendKeys("nayangogoi@gmail.com");
	       
	       WebElement btn = driver.findElement(By.id("loginbutton"));
	       HighLight.highLightElement(driver, btn);
	       btn.click();

	}

}
