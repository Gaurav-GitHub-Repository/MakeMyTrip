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

public class TestCase4 {

	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(TestCase4.class.getName());
	
//	@Parameters({"browser"})
	@Test(priority=1)
	public void InitializeBrowser()
	{
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void functional() throws IOException
	{
		Dashboard dashboard = new Dashboard(driver);
		dashboard.FromCityOption();
		dashboard.SearchCity("Hyderabad");
		dashboard.selectFromAirport();
		dashboard.selectToAirport();
		dashboard.SearchToCity("New Delhi");
		dashboard.selectToAirportCity();
		Checkbox_Dashboard checkbox_dashboard = new Checkbox_Dashboard(driver);
		checkbox_dashboard.searchButton();
		driver.navigate().refresh();
	}
//	@Test(priority=3)
//	public void logout()
//	{
//		driver.quit();
//	} 
}
