package TEST;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.ScreenShot;

public class ListenerTest extends BaseTest implements ITestListener {
//public static WebDriver driver; 
	public void onTestStart(ITestResult result) {    //ITestResult  This class describes the result of a test.

		
		System.out.println("My Test Started"+ result.getName());//getName() method of ITestResult class and returns string typically identical to the name of the method. 
	
	}
public void onTestSuccess(ITestResult result) {
		
		System.out.println("My Test Successfull"+result.getName());
		
	}
 public void onTestFailure(ITestResult result) {   // in Listeners interface method not support to throws keyword 
	
		try {
			ScreenShot.screenshotMethod(driver, result.getName());// 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
}
 
 public void onTestSkipped(ITestResult result) {
	
	System.out.println("My Test Skipped"+result.getName());
	
}

 public void onFinish(ITestResult result) {
		
	System.out.println("My Test finished"+result.getName());
	
}
}
