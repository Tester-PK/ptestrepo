package Pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class OpenBrowser {
	public static WebDriver Browser(String url) throws InterruptedException {  // this method returns the WebDriver which is driver 
		System.setProperty("webdriver.chrome.driver", "F:\\Automation\\KiteZerodha\\src\\main\\resources\\chromedriver.exe"); 
		
		//ChromeOptions opt=new ChromeOptions();//class of selenium
	
		//opt.addArguments("--disable-notifications--");//to disable the chrome browser notifications 
	
		WebDriver driver=new ChromeDriver();// pass the ChromeOptions reference here 
		driver.get(url);
	    driver.manage().window().maximize();
	  
	    //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);//implicitWait
        return driver;
		}
}
