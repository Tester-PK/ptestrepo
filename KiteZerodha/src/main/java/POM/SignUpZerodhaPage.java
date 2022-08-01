package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SignUpZerodhaPage {

	@FindBy(xpath="//img[@class='logo-img']")private WebElement logo;
	@FindBy(xpath="//input[@id='user_mobile']")private WebElement mobileNumber;
	
	public SignUpZerodhaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}

   public boolean logoIsDisplayed(WebDriver driver)
   {
	return logo.isDisplayed();
   }
  
   public void enterMobileNumber(String number)
   {
	mobileNumber.sendKeys(number);
   }

}
