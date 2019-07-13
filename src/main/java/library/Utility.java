package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void captureScreenShot(WebDriver driver,String screenshotname){
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;						// TakesScreenShot is an Interface ,hence we are typecasting it
			File source =  ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshots/"+screenshotname+".png"));
			
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" +e.getMessage());
		} 
	}

}
