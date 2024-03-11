package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Pages.Dashboard;
import Pages.DatePicker_Dashboard;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class TestCase2 {
	
	static WebDriver driver;

	@Parameters({"browser","url"})
	@Test(groups = "InitializeBrowser")
	public void InitializeBrowser(String browser, String url) throws IOException
	{
		if(browser.equals("ChromeBrowser"))
		{
			System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();	
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equals("FirefoxBrowser"))
		{
			System.setProperty("WebDriver.gecko.Driver", "C:\\Selenium Temp\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();	
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equals("EdgeBrowser"))
		{
			System.setProperty("WebDriver.edge.Driver", "C:\\Selenium Temp\\EdgeDriver\\v122\\msedgedriver.exe");
			driver = new EdgeDriver();	
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} 
		else
		{
			System.out.println("Browser is not launched");		}
	}
	@Test(groups = "FunctionalTest")
	public void functional() throws IOException, InterruptedException
	{
		DatePicker_Dashboard dashboard1 = new DatePicker_Dashboard(driver);
		dashboard1.departuredropdown();
		dashboard1.selectMonth();
		dashboard1.selectDate();
		dashboard1.returndropdown();
		dashboard1.selectReturnMonth();
		dashboard1.selectReturnDate();
		dashboard1.travellerDropdown();
		dashboard1.selectAdultSeat();
		dashboard1.selectTravellerClass();
		dashboard1.ApplyButton();	
	}
/*	@Test(groups = "Logout")
	public void logout()
	{
		driver.quit();
	} */
}
