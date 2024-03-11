package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.RadioButton_Dashboard;

public class TestCase1_1 {

	static WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(TestCase1_1.class.getName());	
	
	@Parameters({"browser","url"})
	@Test(priority=1)
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
	@Test(priority=2)
	public void initialize() throws InterruptedException
	{
		//Method to call RadioButton_Dashboard page
		RadioButton_Dashboard dashboard = new RadioButton_Dashboard(driver);
		dashboard.regularfare();
		dashboard.armedforcesfare();
		dashboard.studentfare();
		dashboard.seniorcitizenfare();
		dashboard.doctor();
		dashboard.doubleseat();
	}
	@Test(priority=3)
	public void logout()
	{
		driver.quit();
		log.error("JavaSocket Exception occured");
	}
	}
