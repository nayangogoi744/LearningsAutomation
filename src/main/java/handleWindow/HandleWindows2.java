package handleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://www.naukri.com");
	       String parent = driver.getWindowHandle();
	       System.out.println("Parent Window is: "+parent);
	      
	       Thread.sleep(2000);
	       Set<String> child = driver.getWindowHandles();
	       System.out.println("Count :"+child.size());
	       
	       for(String el:child){
	    	   if(!parent.equals(el)){
	    		   driver.switchTo().window(el);
	    		   System.out.println(driver.getTitle());
	    		   Thread.sleep(3000);
	    		   driver.close();        // It will close the current window
	    		   
	    	   }
	    	   
	       }
	       driver.switchTo().window(parent);
	       String s = driver.getTitle();
	       System.out.println("Parent window: "+s);
	       driver.quit();

	}

}
