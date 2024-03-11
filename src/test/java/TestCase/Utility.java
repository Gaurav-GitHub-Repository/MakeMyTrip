package TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Utility implements ITestListener{

	WebDriver driver;
	
	public void OnTestStart(ITestResult result)
	{
		System.out.println("onTestStart");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("onTestSuccess");
	}
	public void onTestFailure(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File SourceFile = screenshot.getScreenshotAs(OutputType.FILE);
				File TargetFile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
				FileUtils.copyFile(SourceFile, TargetFile);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("onTestSkipped");
	}
	public void onTestFailedWithTimeout(ITestResult result)
	{
		System.out.println("onTestFailedWithTimeout");
	}

}
