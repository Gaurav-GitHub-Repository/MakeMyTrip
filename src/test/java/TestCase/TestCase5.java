package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Pages.Checkbox_Dashboard;
import Pages.Dashboard;
import Pages.DatePicker_Dashboard;
import Pages.RadioButton_Dashboard;

public class TestCase5 {

	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(TestCase5.class.getName());
	
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
	public void flightbook() throws InterruptedException, IOException
	{
		Dashboard dashboard5 = new Dashboard(driver);
		dashboard5.CloseAd();
		RadioButton_Dashboard dashboard = new RadioButton_Dashboard(driver);
		dashboard.oneway();
		dashboard.regularfare();
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
		Dashboard dashboard2 = new Dashboard(driver);
		dashboard2.FromCityOption();
		dashboard2.SearchCity("Hyderabad");
		dashboard2.selectFromAirport();
		dashboard2.selectToAirport();
		dashboard2.SearchToCity("New Delhi");
		dashboard2.selectToAirportCity();
		Dashboard dashboard4 = new Dashboard(driver);
		dashboard4.refreshPage();
		Checkbox_Dashboard dashboard3 = new Checkbox_Dashboard(driver);
		dashboard5.CloseAd();
		dashboard3.searchButton();
		dashboard5.CloseAd();
	}
		@Test(priority=3)
		public void functional() throws InterruptedException, IOException
		{
		Checkbox_Dashboard dashboard3 = new Checkbox_Dashboard(driver);
		dashboard3.PopButton();
		//dashboard3.NonStopCheckbox();
		dashboard3.NonStopCheckbox1();
		}
		@Test(priority=4)
		public void logout()
		{
			driver.quit();
		} 
}
