package Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker_Dashboard {

	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(DatePicker_Dashboard.class.getName());
	
	public DatePicker_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for departure dropdown
	By DepartureDropdown = By.xpath("//div[@id='root']/div[1]/div[2]/div[1]/div[1]/div/div[2]/div/div[3]/label/span");
	//Locator for month dropdown 
	By MonthDropdown = By.xpath("//span[@aria-label='Next Month']");
	//Locator for month
	By month = By.xpath("//div[@class='DayPicker-Month'][2]/div/div[text()='August']");
	//Locator for return dropdown
	By ReturnDropdown = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/div[2]/label/span");
	//Locator for traveller
	By TravellerDropdown = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div[5]/label/p[2]");
	//Locator for adult dropdown
	By Adult = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div[5]/div[2]/div/ul/li[1]");
	//Locator for traveller class
	By TravellerClass = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div[5]/div[2]/div[1]/ul[2]/li[1]");
	//Locator for apply button
	By ApplyButton = By.xpath("//div[@id='root']/div[1]/div[2]/div[1]/div/div/div[2]/div/div[5]/div[2]/div[2]/button");
	
	//Method to click on departure dropdown
	public void departuredropdown() throws InterruptedException
	{
		driver.findElement(DepartureDropdown).click();
		Thread.sleep(2000);
	}
	
	//Method to select month
	public void selectMonth()
	{
		int count=1;
		for(int i=8; i>=0; i++)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	
			count++;
			if(count==6)
			{
				break;
			}			
		}
	}	
	//Method to select date
	public void selectDate() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='DayPicker-Months'][1]/div[2]/div[3]/div[3]/div[5]/div")).click();
		Thread.sleep(2000);
	}
	//Method to verify month and date
	public void verifyDeparture()
	{
		String Date = driver.findElement(By.xpath("//div[@id='root'][1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/p/span")).getText();
		if(Date.contains("15"))
		{
			System.out.println("Departure Date is verified");
		}
	}
	//Method to click on return dropdown
	public void returndropdown() throws InterruptedException
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ReturnDropdown));
		driver.findElement(ReturnDropdown).click();
		Thread.sleep(2000);
		}
		catch(TimeoutException e)
		{
			System.out.println("TimeoutException");
		}
	}
	//Method to select month
	public void selectReturnMonth()
	{
		int count=1;
		for(int i=8; i>=0; i++)
		{
			//By dropdown = By.xpath("//span[@aria-label='Next Month']");
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdown));
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			count++;
			if(count==2)
			{
				break;
			}			
		}
	}
	//Method to select date
	public void selectReturnDate() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='DayPicker-Months'][1]/div[2]/div[3]/div[3]/div[5]/div")).click();
		Thread.sleep(2000);
	}
	//Method to click on traveller dropdown
	public void travellerDropdown() throws InterruptedException
	{
		driver.findElement(TravellerDropdown).click();
		Thread.sleep(2000);
	}
	//Method to click on adult button
	public void selectAdultSeat() throws InterruptedException
	{
		driver.findElement(Adult).click();
		Thread.sleep(2000);
	}
	//Method to select traveller class
	public void selectTravellerClass() throws InterruptedException
	{
		driver.findElement(TravellerClass).click();
		Thread.sleep(2000);
	}
	//Method to click on apply button
	public void ApplyButton() throws InterruptedException
	{
		driver.findElement(ApplyButton).click();
		Thread.sleep(2000);
	}
	}
	

