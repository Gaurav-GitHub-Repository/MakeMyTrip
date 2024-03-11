package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Pages.Checkbox_Dashboard;
import Pages.Dashboard;
import Pages.DatePicker_Dashboard;
import Pages.Dropdown_Dashboard;
import Pages.Payment_Dashboard;
import Pages.RadioButton_Dashboard;


public class EndToEnd1 {

	WebDriver driver;

//	@Parameter("Browser")
	@Test(priority=1)
	public void initialize() throws InterruptedException
	{
		System.setProperty("Webdriver.edge.driver", "C:\\Selenium Temp\\EdgeDriver\\v122\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void flightbook() throws InterruptedException, IOException
	{
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
		dashboard3.searchButton();
	}
		@Test(priority=3)
		public void functional() throws InterruptedException, IOException
		{
		Checkbox_Dashboard dashboard3 = new Checkbox_Dashboard(driver);
		dashboard3.PopButton();
		dashboard3.NonStopCheckbox();
	//	dashboard3.scroll();
	//	dashboard3.selectAirline();
		dashboard3.bookflight();
	//	dashboard3.BookButton();
	//	dashboard3.BookButton();
		dashboard3.ContinueBtn();
		dashboard3.ContinueBtn();
		}
		@Test(priority=4)
		public void regression() throws InterruptedException, IOException
		{
		Checkbox_Dashboard checkbox_dashboard = new Checkbox_Dashboard(driver);	
		checkbox_dashboard.SwitchWindow();
		//Method to call dashboard page
		Dashboard dashboard4 = new Dashboard(driver);
		dashboard4.refreshPage();
		//Method to call Dropdown_Dashboard
		Dropdown_Dashboard dropdown_Dashboard = new Dropdown_Dashboard(driver);
		dropdown_Dashboard.AddDetails();
		dropdown_Dashboard.enterFirstName("abc");
		dropdown_Dashboard.enterLastName("abc");
		dropdown_Dashboard.selectGender();
	//	dropdown_Dashboard.SelectCountryCode();
	//	dashboard3.scroll1();
		checkbox_dashboard.enterMobileNumber("8919876100");
		checkbox_dashboard.enterEmail("abc@gmail.com");
		checkbox_dashboard.SelectEmail();
	//	dashboard3.scroll2();
		checkbox_dashboard.ConfirmButton();
	//	checkbox_dashboard.AdultCheckbox();
		checkbox_dashboard.TravellerContinueButton();
		}
		@Test(priority=5)
		public void flight3() throws InterruptedException, IOException
		{
		Dropdown_Dashboard dropdown_dashboard = new Dropdown_Dashboard(driver);	
		dropdown_dashboard.ConfirmReviewButton();
		dropdown_dashboard.SkipButton();
		dropdown_dashboard.SkipAddOnButton();
		dropdown_dashboard.SkipButton();
		dropdown_dashboard.FlightContinueButton();
		}
		@Test(priority=6)
		public void payment() throws InterruptedException
		{
		Payment_Dashboard payment_Dashboard = new Payment_Dashboard(driver);
		payment_Dashboard.SwitchToPaymentWindow();
		payment_Dashboard.ProceedToButton();
		payment_Dashboard.enterCardNumber("123456789123");
		payment_Dashboard.enterCardName("abc");
		payment_Dashboard.selectMonth();
		payment_Dashboard.selectYear();
		payment_Dashboard.Pay_Button();
		}
	}

