package com.testtalks.karatedemo.MavenProjectSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class DynamicDropDown 
{
    public static void main( String[] args )
    {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
       driver.findElement(By.xpath("//button[@id='menu1']")).click();
       
       List<WebElement> dd_menu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
       
       for(int i = 0 ;i<dd_menu.size();i++){
    	   WebElement e = dd_menu.get(i);
    	   //System.out.println("Element------"+e);
    	   System.out.println(e.getAttribute("innerHTML"));
    	   String check = e.getAttribute("innerHTML");
    	   if(check.contentEquals("JavaScript")){
    		   e.click();
    		   break;
    	   }
       }
    }
}
