package TEST;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.LoginZerodhaPage;
import Utility.Excel;
import Pojo.OpenBrowser;
import Utility.Reports;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenerTest.class)

public class LoginTest extends BaseTest {
	
//public static WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void setReports() {
		reports=Reports.addReport();
	}
	

	@BeforeMethod
	public void callbrowser() throws InterruptedException {
	//	driver=OpenBrowser.Browser("http://kite.zerodha.com");
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		Thread.sleep(5000);
	}
	
	@Test
	public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(5000);
		test=reports.createTest("LoginWithValidCredentials");// for ExtentReports we have explicitly tell for which test methods you have to generate the report as it will not take by itself  
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		String username=Excel.getTestData(0, 1, "Credentials");
		loginzerodha.enterUserName(username);
		String pass=Excel.getTestData(1, 1, "Credentials");
		loginzerodha.enterPassword(pass);
		loginzerodha.clickOnLogin();
		String pinNumber=Excel.getTestData(2, 1, "Credentials");
		loginzerodha.enterPin(pinNumber, driver);
		loginzerodha.clickOnPinSubmit();
		Assert.assertTrue(true);
		Thread.sleep(5000);
	}
	
	@Test(enabled=false)
	public void LoginWithInvalidCredentials() throws EncryptedDocumentException, IOException
	{
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		String username=Excel.getTestData(0, 2, "Credentials");
		loginzerodha.enterUserName(username);
		String pass=Excel.getTestData(1, 2, "Credentials");
		loginzerodha.enterPassword(pass);
		loginzerodha.clickOnLogin();
	}

	@Test(enabled=false)
	public void LoginWithInvaildUsernameCredentials() throws EncryptedDocumentException, IOException
	{
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		String username=Excel.getTestData(0, 2, "Credentials");
		loginzerodha.enterUserName(username);
		String pass=Excel.getTestData(1, 1, "Credentials");
		loginzerodha.enterPassword(pass);
		loginzerodha.clickOnLogin();
	}
	
	@Test(enabled=false)
	public void LoginWithInvaildPasswordCredentials() throws EncryptedDocumentException, IOException
	{
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		String username=Excel.getTestData(0, 1, "Credentials");
		loginzerodha.enterUserName(username);
		String pass=Excel.getTestData(1, 2, "Credentials");
		loginzerodha.enterPassword(pass);
		loginzerodha.clickOnLogin();
	}
	
	@Test
	public void LoginWithoutCredentials() 
	{
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		loginzerodha.clickOnLogin();
		Thread.sleep(5000);
		//Assert.assertTrue(false);
		  SoftAssert assertion=new SoftAssert();//soft assert
		
		    assertion.assertTrue(loginzerodha.errorMessageDiaplyed());
		    assertion.assertAll();
	}
	
	@AfterMethod
	public void createResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else 
		{
			
			test.log(Status.SKIP, result.getName());
		}
	
    }
			

	@AfterClass
	public void flushResults() 
	{
		reports.flush();
		
		driver.close();
	}
}
