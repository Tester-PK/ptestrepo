package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy(xpath="//button[@class='button-blue buy']")private WebElement buy;
	@FindBy(xpath="//span[text()='TATACOFFEE']")private WebElement tataCoffee;
	@FindBy(xpath="//div[@class='vddl-list list-flat']//span//span//span[@class='nice-name']")private List<WebElement> stockList;
	@FindBy(xpath="//button[@type='submit']")private WebElement mainBuy;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnTataCoffee(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(4000));
		wait.until(ExpectedConditions.visibilityOf(tataCoffee));
		Actions action=new Actions(driver);
		action.moveToElement(tataCoffee);
		action.perform();
	}
	
	public void selectFromsStockList(WebDriver driver, String stockName) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(4000));
		wait.until(ExpectedConditions.visibilityOf(tataCoffee));
        for(int a=0; a<stockList.size();a++)
        {
        	String text=stockList.get(a).getText();
        	System.out.println(stockList.size());
            if(text.equalsIgnoreCase(stockName)) 
            {
             Actions action=new Actions(driver);
             action.moveToElement(stockList.get(a));
             action.perform();
             break;
            }
        
	    }
	
	}
	
	public void clickOnBuy() {
		buy.click();
	}
	
	public boolean isDisplayedMainBuy() 
	{
		return mainBuy.isDisplayed();
      }
	 
}