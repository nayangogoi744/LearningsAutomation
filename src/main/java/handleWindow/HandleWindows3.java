package handleWindow;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("http://www.naukri.com");
	       String parent = driver.getWindowHandle();
	       System.out.println("Parent Window is: "+parent);
	      
	       Thread.sleep(2000);
	       Set<String> allwindows = driver.getWindowHandles();
	       ArrayList<String> tabs = new ArrayList<String>(allwindows);
	       driver.switchTo().window(tabs.get(2));
	       driver.close();
	       Thread.sleep(1000);
	       
	       driver.switchTo().window(tabs.get(1));
	       driver.close();
	       Thread.sleep(1000);
	       
	       driver.switchTo().window(tabs.get(0));
	       Thread.sleep(1000);
	       
	      	System.out.println("Title of parent is :"+driver.getTitle());
	      	driver.quit();



	}

}
