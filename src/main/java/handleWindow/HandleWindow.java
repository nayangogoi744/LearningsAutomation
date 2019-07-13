package handleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
	       String parent = driver.getWindowHandle();
	       System.out.println("Parent Window is: "+parent);
	       
	       driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
	       Thread.sleep(2000);
	       Set<String> child = driver.getWindowHandles();
	       System.out.println("Count :"+child.size());
	       
	       for(String el:child){
	    	   if(!parent.equals(el)){
	    		   driver.switchTo().window(el);
	    		   driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello");
	    		   Thread.sleep(3000);
	    		   driver.close();        // It will close the current window
	    		   
	    	   }
	    	   
	       }
	       driver.switchTo().window(parent);
	       String s = driver.getTitle();
	       System.out.println("Parent window: "+s);

	}

}
