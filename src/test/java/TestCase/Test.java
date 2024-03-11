package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Checkbox_Dashboard;

public class Test {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/flight/search?itinerary=HYD-DEL-16/02/2024&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Checkbox_Dashboard dashboard3 = new Checkbox_Dashboard(driver);
		dashboard3.PopButton();
		dashboard3.NonStopCheckbox1();
		dashboard3.selectAirline1();
		dashboard3.bookButton1();
	}

}
