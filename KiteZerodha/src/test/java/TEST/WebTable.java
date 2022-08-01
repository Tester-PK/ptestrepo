package TEST;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pojo.OpenBrowser;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=OpenBrowser.Browser("https://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> row=driver.findElements(By.xpath("//table//tbody//tr"));
		List<WebElement> column=driver.findElements(By.xpath("//table//thead//tr//th"));
		
		double basePrice=0;
		double maxPrice=0;
		
		if(column.size()>3)
	{
			
		 for(int i=2; i<=row.size(); i++) 
		  {
			 for(int j=1; j<=column.size(); j++) 
			 {
			 WebElement currentPrice=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+j+"]"));
				String price=currentPrice.getText();
			    maxPrice=Double.parseDouble(price);//convert string to double //223.5 555.3
			     if(maxPrice>basePrice) 
			    {
			
				basePrice=maxPrice;		  // 223.5 555.3
		        }
		     }
		 }
		 System.out.println(basePrice);
		  
	}	
	else
	{
			System.out.println("currently 3rd coulmn not oresent");
	}
		
		
	}
		
	}


