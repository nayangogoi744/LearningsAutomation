package handleWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       driver.get("file://C://Users//njy//Desktop//Tryit Editor v3.6.html");
	       driver.switchTo().frame("iframeResult");
	       driver.findElement(By.xpath("//button[text()='Try it']")).click();
	       Thread.sleep(2000);
	       System.out.println(driver.switchTo().alert().getText());
	       driver.switchTo().alert().accept();
	      	//driver.quit();



	}

}
