package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Checkbox_Dashboard;
import Pages.Dashboard;

public class TestCase3 {

	
	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(TestCase3.class.getName());
	
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
	public void functional() throws IOException
	{
		Dashboard dashboard = new Dashboard(driver);
		dashboard.Logo();
		Checkbox_Dashboard checkbox_dashboard = new Checkbox_Dashboard(driver);
		checkbox_dashboard.searchButton();
	}
	@Test(groups = "Logout")
	public void logout()
	{
		driver.quit();
		log.error("JavaSocket Exception occured");
	} 
}
