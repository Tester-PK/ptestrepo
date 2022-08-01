package TEST;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.LoginZerodhaPage;
import POM.SignUpZerodhaPage;
import Utility.OpenBrowser;
import Utility.ScreenShot;

public class SignUpTest {

WebDriver driver;
	
	@BeforeMethod
	public void callbrowser() {
		driver=OpenBrowser.Browser("http://kite.zerodha.com/");
	}

	@Test
	public void signUpApp() throws EncryptedDocumentException, IOException, InterruptedException
	{
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		loginzerodha.clickOnSignUpAccount();
		
		ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		
	    SignUpZerodhaPage signupzerodha=new SignUpZerodhaPage(driver);;
	    String actualTitle= signupzerodha.getPageTitle(driver);
	    String exceptedTitle= "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
        Assert.assertEquals(actualTitle, exceptedTitle);//hard assert
 
        Assert.assertFalse(signupzerodha.logoIsDisplayed(driver));//hard assert
        
        signupzerodha.enterMobileNumber("7875863071");
        
		ScreenShot.screenshotMethod(driver, "loginpage");
	}

    @Test	
    public void testsignUp()
     {
	LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
	loginzerodha.clickOnSignUpAccount();
	
	ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(list.get(1));
	
    SignUpZerodhaPage signupzerodha=new SignUpZerodhaPage(driver);;
    String actualTitle= signupzerodha.getPageTitle(driver);
    String exceptedTitle="Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
    SoftAssert assertion=new SoftAssert();//soft assert
    assertion.assertEquals(actualTitle, exceptedTitle);
    assertion.assertFalse(signupzerodha.logoIsDisplayed(driver));//soft assert
    assertion.assertAll();
    signupzerodha.enterMobileNumber("7875863071");
    }
}

