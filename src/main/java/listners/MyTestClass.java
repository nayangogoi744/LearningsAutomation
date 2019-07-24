package listners;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(listners.ListenersClass.class)
public class MyTestClass extends Base{

	@Test
	public void verifyTitle(){
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String s = driver.getTitle();
		System.out.println(s);
		Assert.assertEquals(true, false);
		
	}
}
