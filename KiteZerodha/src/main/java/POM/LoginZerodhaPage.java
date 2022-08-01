package POM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginZerodhaPage {

	@FindBy(xpath="//input[@id='userid']")private WebElement userName; 
	@FindBy(xpath="//input[@id='password']")private  WebElement password;
    @FindBy(xpath="//button[@type='submit']")private WebElement login;
    @FindBy(xpath="//input[@id='pin']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement pinSubmit;
	@FindBy(xpath="//a[text()='Change user']")private WebElement chnageUser;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgotPassword;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signUpAccount;
	@FindBy(xpath="//span[text()='User ID should be minimum 6 characters.']")private WebElement errorMessgage;
	


	public LoginZerodhaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);// PageFactory.initElements this will find the all the elements declared at the start 	
	}
	
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	
	public void enterPassword(String pass){
		password.sendKeys(pass);
	}
	
	public void clickOnLogin(){
		login.click();
	}
	
	public void enterPin(String pinNumber, WebDriver driver) throws IOException, InterruptedException{
		
		// ExplicitWait
		//WebDriverWait wait= new WebDriverWait(driver, 3000);
		//wait.until(ExpectedConditions.visibilityOf(pin));
		//
		
		// FluentWait
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(pin));  // or we can use wait.until(ExpectedConditions.visibilityOfElementLoccated(By.xpath("xpath expression")))
		pin.sendKeys(pinNumber);
		
	}
	public void clickOnPinSubmit(){
		pinSubmit.click();
	}

	public void clickOnChnageUser(){
		chnageUser.click();
	}
	
	public void clickOnForgotPassword(){
		forgotPassword.click();
	}
	
	public void clickOnSignUpAccount(){
		signUpAccount.click();
	}
	public boolean errorMessageDiaplyed(){
		return (errorMessgage.isDisplayed());
		
	}
	
}
