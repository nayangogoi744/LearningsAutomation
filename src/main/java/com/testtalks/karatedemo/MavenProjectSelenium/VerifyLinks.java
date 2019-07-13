package com.testtalks.karatedemo.MavenProjectSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://seleniumpractise.blogspot.com");
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("Total links : "+links.size());
	   for(int i=0;i<links.size();i++){
		   WebElement el = links.get(i);
		   String url = el.getAttribute("href");
		   verifyLinks(url);
	   }
	   driver.quit();
	   
	   }

	 public static void verifyLinks(String linkurl) throws IOException{
		   
		try {
			URL url = new URL(linkurl);
			
			HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setConnectTimeout(3000);
			httpconnection.connect();
			if(httpconnection.getResponseCode()==200){
			System.out.println(linkurl+ "--"+httpconnection.getResponseMessage());
				
				
			}
			if(httpconnection.getResponseCode()==httpconnection.HTTP_NOT_FOUND){
				System.out.println(linkurl+ "--"+httpconnection.getResponseMessage()+ "--"+httpconnection.HTTP_NOT_FOUND);
			}
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	   }
	       

	}

