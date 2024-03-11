package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.RadioButton_Dashboard;

//TestCase 1: Select radio button in dashboard and verify if it is displayed
public class TestCase1  {

	public WebDriver driver;
		
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(TestCase1.class.getName());
	
	@Parameters({"browser","url"})
	@Test(groups = "InitializeBrowser")
	public void InitializeBrowser(String browser, String url) throws IOException
	{
		if(browser.equals("ChromeBrowser"))
		{
			System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();	
			log.info("Chrome Browser is launched");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equals("FirefoxBrowser"))
		{
			System.setProperty("WebDriver.gecko.Driver", "C:\\Selenium Temp\\FirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();	
			log.info("Firefox Browser is launched");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equals("EdgeBrowser"))
		{
			System.setProperty("WebDriver.edge.Driver", "C:\\Selenium Temp\\EdgeDriver\\v122\\msedgedriver.exe");
			driver = new EdgeDriver();	
			log.info("Edge Browser is launched");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} 
		else
		{
			log.error("Browser is not launched");
		}
	}
	@Test(groups = "FunctionalTest")
	public void FunctionalTest() throws InterruptedException
	{
		//Method to call RadioButton_Dashboard page
		RadioButton_Dashboard dashboard = new RadioButton_Dashboard(driver);
		dashboard.oneway();
		dashboard.roundtrip();
		dashboard.multiway();
	}
	@Test(groups = "Logout")
	public void logout()
	{
		driver.quit();
		log.error("JavaSocket Exception occured");
	} 
}
