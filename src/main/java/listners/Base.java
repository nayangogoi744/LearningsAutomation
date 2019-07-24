package listners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Base {

	public static WebDriver driver;
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
