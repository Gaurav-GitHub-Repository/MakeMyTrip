package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown_Dashboard {

	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(Dropdown_Dashboard.class.getName());
	
	public Dropdown_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	 //Locator for add adult details 
	 By AddAdult = By.xpath("//button[@type='button' and @class='addTravellerBtn']");
	 //Locator for first name
	 By FirstName = By.xpath("//input[@placeholder='First & Middle Name' and @type='text']");
	 //Locator for last name
	 By LastName = By.xpath("//input[@placeholder='Last Name' and @type='text']");
	 //Locator for gender 
//	 By Gender = By.xpath("//div[@id='TRAVELLER_DETAIL']/div/div/div[3]/div[3]/div/div/div/div/div/div[3]/div/div/label/span[text()='MALE']");
//	 By Gender = By.xpath("//span[text()='MALE']");
	 By Gender = By.xpath("//input[@type='radio' and @value='MALE']");
	 //Locator for countrycode dropdown
	 By CountryCodeDropdown = By.xpath("//div[@id='TRAVELLER_DETAIL']/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div/div/div/div/div");
	 //Locator for country extension
	 By CountryExtension = By.xpath("//div[@id='TRAVELLER_DETAIL']/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div/div/div/div/div");
	 //Locator for confirm review button
	 By ConfirmReviewButton = By.xpath("//button[text()='CONFIRM']");
	 //Locator for skip seat button
	 By SkipSeatButton = By.xpath("//span[text()='Skip Seat Selection']");
	 //Locato for skip add on button
	 By SkipAddOn = By.xpath("//span[text()='Skip to add-ons']");
	 //Locator for continue button
	 By ContinueButton = By.xpath("//button[text()='Continue']");
	 
	 //Method to add adult details
	 public void AddDetails() throws InterruptedException, IOException
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AddAdult));
		 driver.findElement(AddAdult).click();
		 TakesScreenshot screenshot = (TakesScreenshot)driver;
		 File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		 File targetfile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
		 FileHandler.copy(sourcefile, targetfile);
		 }
		 catch(ElementNotInteractableException e)
		 {
			 System.out.println("ElementNotInteractableException");
		 }
	 }
	 //Method to enter first name
	 public void enterFirstName(String value) throws InterruptedException
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(FirstName));
		 driver.findElement(FirstName).sendKeys(value);
		 driver.findElement(FirstName).sendKeys(Keys.TAB);
		 }
		 catch(ElementNotInteractableException e)
		 {
			 System.out.println("ElementNotInteractableException");
		 }
		 catch(NoSuchElementException e)
		 {
			 System.out.println("NoSuchElementException");
		 }
	 }
	 //Method to enter last name
	 public void enterLastName(String value1) throws InterruptedException
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(LastName));
		 driver.findElement(LastName).sendKeys(value1);
		 driver.findElement(LastName).sendKeys(Keys.TAB);
		 }
		 catch(ElementNotInteractableException e)
		 {
			 System.out.println("ElementNotInteractableException");
		 }
		 catch(NoSuchElementException e)
		 {
			 System.out.println("NoSuchElementException");
		 }
	 }
	 //Method to select gender
	 public void selectGender()
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Gender));
		 driver.findElement(Gender).click();
		 }
		 catch(ElementClickInterceptedException e)
		 {
			 System.out.println("ElementClickInterceptedException");
		 }
		 catch(ElementNotInteractableException e)
		 {
			 System.out.println("ElementNotInteractableException");
		 }
	 }
	 //Method to select country dropdown
	 public void SelectCountryCode() throws InterruptedException
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(CountryCodeDropdown));	 
		 driver.findElement(CountryCodeDropdown).click();
		 driver.findElement(CountryExtension).click();
		 }
		 catch(TimeoutException e)
		 {
			 System.out.println("TimeoutException");
		 }
	 }
	 //Method to click on review button
	 public void ConfirmReviewButton() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 driver.findElement(ConfirmReviewButton).click();
	 }
	 //Method to click on skip seat
	 public void SkipButton() throws InterruptedException, IOException
	 {
		 try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SkipSeatButton));	 
		 driver.findElement(SkipSeatButton).click();
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
			File targetfile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
			FileHandler.copy(sourcefile, targetfile);	
		 }
		 catch(TimeoutException e)
		 {
			 System.out.println("TimeoutException");
		 }
	 }
	 //Method to click on skip button
	 public void SkipAddOnButton() throws InterruptedException, IOException
	 {
		 driver.findElement(SkipAddOn).click();
		 Thread.sleep(2000);
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
			File targetfile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
			FileHandler.copy(sourcefile, targetfile);	 
	 }
	 //Method to click on continue button
	 public void FlightContinueButton() throws InterruptedException
	 {
		 try {
		 Thread.sleep(2000);
		 driver.findElement(ContinueButton).click();
		 }
		 catch(NoSuchElementException e)
		 {
			 System.out.println("NoSuchElementExceptions");
		 }
	 }
}
