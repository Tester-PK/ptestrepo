package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	public static void screenshotMethod(WebDriver driver, String name) throws IOException, InterruptedException 
	{
           
		    String d=getDateTime.dateTimes();
		     
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destination=new File("F:\\Automation\\KiteZerodha\\ScreenShots\\"+name+" "+d+".jpg");
			
			FileHandler.copy(source, destination);	
			
	}

	
}
