package Pages;

import java.time.Duration;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCase.TestCase1;

public class RadioButton_Dashboard {

	WebDriver driver;
		
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(RadioButton_Dashboard.class.getName()); 
	 
	public RadioButton_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for one way radio button
	By OneWayRadioButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/ul/li[text()='One Way']");
	//Locator for round trip radio button
	By RoundTripRadioButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/ul/li[2][text()='Round Trip']");
	//Locator for multi city radio button
	By MultiCityRadioButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/ul/li[text()='Multi City']");
	//Locator for regular fare
	By RegularFareRadioButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li/p");
	//Locator for armed forces fares
	By ArmedForcesFare = By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[2]/p");
//	By ArmedForcesFare = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[3]/div/ul/li[2]/div/p[text()='Armed Forces Fares']");							   
//	By ArmedForcesFare = By.xpath("//div[@class='fsw ']/div[2]/div/ul/li[2]/p");
	//Locator for student fare
	By StudentFare = By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[3]/p");
	//Locator for senior citizen fares
	By SeniorCitizenFare = By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[4]/p[text()='Senior Citizen ']");
	//Locator for Doctor & Nurses radio button
	By DoctorandNursesRadioButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[5]/p[text()='Doctors & Nurses ']");
	//Locator for Double seat fare radio button
	By DoubleSeatRadioButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[6]/p[text()='Double Seat ']");
	
	//Method to click on one way radio button
	public void oneway() throws InterruptedException
	{
		driver.findElement(OneWayRadioButton).click();
		Thread.sleep(2000);
		WebElement OneWayRadioButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/ul/li[text()='One Way']"));
		if(OneWayRadioButton.isDisplayed())
		{
			log.info("One way radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
	//Method to click on round trip radio button
	public void roundtrip() throws InterruptedException
	{
		driver.findElement(RoundTripRadioButton).click();
		Thread.sleep(2000);
		WebElement RoundTripRadioButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/ul/li[2][text()='Round Trip']"));
		if(RoundTripRadioButton.isDisplayed())
		{
			log.info("Round trip radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
	//Method to verify multiway radio button
	public void multiway() throws InterruptedException
	{
		driver.findElement(MultiCityRadioButton).click();
		Thread.sleep(2000);
		WebElement MultiCityRadioButton= driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/ul/li[text()='Multi City']"));
		if(MultiCityRadioButton.isDisplayed())
		{
			log.info("MultiCity radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
	//Method to click on regular fare radio button
	public void regularfare() throws InterruptedException
	{
		driver.findElement(RegularFareRadioButton).click();
		Thread.sleep(2000);
		WebElement RegularFareRadioButton= driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li/p"));
		if(RegularFareRadioButton.isDisplayed())
			{
				log.info("RegularFareRadioButton radio button is selected");
			}
			else
			{
				log.error("One way radio button is selected");
			}
			 
	}
	//Method to verify armed forces radio button
	public void armedforcesfare()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ArmedForcesFare));
		driver.findElement(ArmedForcesFare).click();
		WebElement ArmedForcesFare= driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[2]/p"));
		if(ArmedForcesFare.isDisplayed())
		{
			log.info("RegularFare radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
	//Method to click on student fare radio button
	public void studentfare() throws InterruptedException
	{
		 driver.findElement(StudentFare).click();
		 Thread.sleep(2000);
		 WebElement StudentFare = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[3]/p"));
		 if(StudentFare.isDisplayed())
		 {
			 log.info("StudentFare radio button is selected");
		 }
		 else
		 {
			 log.error("One way radio button is selected");
		 }
	}
	//Method to click on senior citizen fare radio button
	public void seniorcitizenfare() throws InterruptedException
	{
		driver.findElement(SeniorCitizenFare).click();
		Thread.sleep(2000);
		WebElement SeniorCitizenFare = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[4]/p[text()='Senior Citizen ']"));
		if(SeniorCitizenFare.isDisplayed())
		{
			log.info("SeniorCitizenFare radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
	//Method to click on doctor & nurses radio button
	public void doctor() throws InterruptedException
	{
		driver.findElement(DoctorandNursesRadioButton).click();
		Thread.sleep(2000);
		WebElement DoctorandNursesRadioButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[5]/p[text()='Doctors & Nurses ']"));
		if(DoctorandNursesRadioButton.isDisplayed())
		{
			log.info("SeniorCitizenFare radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
	public void doubleseat() throws InterruptedException
	{
		driver.findElement(DoubleSeatRadioButton).click();
		Thread.sleep(2000);
		WebElement DoubleSeatRadioButton = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div[1]/div[2]/div[2]/div/ul/li[6]/p[text()='Double Seat ']"));
		if(DoubleSeatRadioButton.isDisplayed())
		{
			log.info("DoubleSeat radio button is selected");
		}
		else
		{
			log.error("One way radio button is selected");
		}
	}
}
