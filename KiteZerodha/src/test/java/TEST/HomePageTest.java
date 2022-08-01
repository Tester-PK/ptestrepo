package TEST;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POM.HomePage;
import POM.LoginZerodhaPage;
import Utility.Excel;
import Utility.OpenBrowser;


public class HomePageTest {
  WebDriver driver;
	
	@BeforeMethod
	public void callURL() throws EncryptedDocumentException, IOException, InterruptedException {
		driver=OpenBrowser.Browser("http://kite.zerodha.com");
		LoginZerodhaPage loginzerodha=new LoginZerodhaPage(driver);
		String username=Excel.getTestData(0, 1, "Credentials");
		loginzerodha.enterUserName(username);
		String pass=Excel.getTestData(1, 1, "Credentials");
		loginzerodha.enterPassword(pass);
		loginzerodha.clickOnLogin();
		String pinNumber=Excel.getTestData(2, 1, "Credentials");
		loginzerodha.enterPin(pinNumber, driver);
		loginzerodha.clickOnPinSubmit();
	}
	
	
	@Test
	public void buyStock() {
		HomePage homepage=new HomePage(driver);
		homepage.selectFromsStockList(driver, "tcs");
		homepage.clickOnBuy();
		Assert.assertTrue(homepage.isDisplayedMainBuy());
	}
	
	/*@Test
	public void buyTataCoffeStock() {
		HomePage homepage=new HomePage(driver);
		homepage.clickOnTataCoffee(driver);
		homepage.clickOnBuy();
		Assert.assertTrue(homepage.isDisplayedMainBuy());
	}
	
	@Test
	public void sellStock(WebDriver driver) {
		HomePage homepage=new HomePage(driver);
		homepage.selectFromsStockList(driver, "tatamotors");
		homepage.clickOnBuy(driver)
		Assert.assertTrue(homepage.isDisplayedMainBuy());
	}*/
	
}
