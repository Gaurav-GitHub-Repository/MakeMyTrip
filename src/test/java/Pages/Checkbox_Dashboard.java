package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkbox_Dashboard {

 WebDriver driver;
 
 static org.apache.logging.log4j.Logger log = LogManager.getLogger(Checkbox_Dashboard.class.getName());
 
 public Checkbox_Dashboard(WebDriver driver)
 {
	 this.driver=driver;
 } 

 //Locator for search button
 By SearchButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/p/a");
 //Locator for pop up
 By PopUp = By.xpath("//button[text()='OKAY, GOT IT!']");
 //Locator for non stop checkbox
 By NonStopCheckbox = By.xpath("//div[@id='root']/div/div/div/div/div/div/div/div/div/div/div/label/span/input");
 //Locator for NonStopCheckbox
 By NonStopCheckbox1 = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/div/div/div/label/span/input");
 //Locator for air india checkbox
 By AirIndia = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[5]/div/div/div/div/label/div/p");
 //Locator for AirIndia
 By AirIndia1 = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/div/div/div[4]/label/span/input");
 //Locator for flight button
 By FlightBookButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div/div/div[3]/div/div[3]/div/div[2]/div/button");
 //Locator for book button
 By BookButton = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[3]/div/button");
 // By ContinueButton = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/button");
 //Locator for Book Button1
 By BookButton1 = By.xpath("//*[@id='bookbutton-RKEY:fc6fb28b-2d8b-448c-8aa7-6f349145e174:49_0']/span");
 By ContinueButton = By.xpath("//div[@id='root']/div/div[2]/div/div/div[2]/div/div/div[2]/div[3]/button");
 //Locator for button
 By ContinueButton1 = By.xpath("//button[text()='Continue']"); 
 //Locator for adult checkbox
 By AdultCheckbox = By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/form/div/div/div[4]/div/div/div/div[3]/div[3]/div/div/label/span/input");
 //Locator for mobile number
 By MobileNumber = By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/form/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/input");
 //Locator for email
 By Email = By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/form/div/div/div[4]/div/div/div[2]/div/div/div[3]/div/input");
 //Locator for email dropdown
 By EmailDropdown = By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/form/div/div/div[4]/div/div/div[2]/div/div//div[3]/div/div/div");
 //Locator for confirm button
 By ConfirmButton = By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/form/div/div/div[5]/div/div/div[3]/div/span/b");
 //Locator for traveller continue button
 By TravellerContinueButton = By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/form/div[2]/button");
 
 
 //Method to click on search button
 public void searchButton()
 {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SearchButton));
	 driver.findElement(SearchButton).click();
	 log.info("Search button is clicked");
 }
 //Method to click on pop up
 public void PopButton() throws InterruptedException
 {
	 try {
	 Thread.sleep(8000);
	 driver.findElement(PopUp).click();
	 }
	 catch(NoSuchElementException e)
	 {
		 log.error("NoSuchElementException occured");
	 }
 }
 //Method to automate slider
 public void AdultCheckbox() throws IOException
 {
	try { 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AdultCheckbox));
	driver.findElement(AdultCheckbox).click();
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
	File targetfile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
	FileHandler.copy(sourcefile, targetfile);
	}
	catch(ElementClickInterceptedException e)
	{
		System.out.println("ElementClickInterceptedException");
	}
 }
 //Method to click on non stop check box
 public void NonStopCheckbox() throws InterruptedException, IOException
 {
	 driver.findElement(NonStopCheckbox).click();
	 Thread.sleep(2000);
	 WebElement Checkbox = driver.findElement(NonStopCheckbox);
	 if(Checkbox.isDisplayed())
	 {
		 System.out.println("NonStopCheckbox is selected");
	 }	 
	 else
	 {
		 System.out.println("NonStopCheckbox is not selected");
		 TakesScreenshot screenshot = (TakesScreenshot)driver;
		 File SourceFile =  screenshot.getScreenshotAs(OutputType.FILE);
		 File TargetFile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\Screenshot1.png");
		 FileUtils.copyDirectory(SourceFile, TargetFile);
	 }
 }
 public void NonStopCheckbox1() throws InterruptedException
 {
	 driver.findElement(NonStopCheckbox1).click();
	 Thread.sleep(2000);
	 WebElement Checkbox = driver.findElement(NonStopCheckbox);
	 if(Checkbox.isDisplayed())
	 {
		 System.out.println("NonStopCheckbox is selected");
	 }
	 else
	 {
		 log.error("NonStopCheckbox is not selected");
	 }
 }
 //Method to scroll
 public void scroll()
 {
	 WebElement Element = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[4]/div/div/p"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", Element);
 }
 //Method to select airline
 public void selectAirline() throws InterruptedException
 {
	 driver.findElement(AirIndia).click();
	 Thread.sleep(2000);
 }
 //Method to select airline
 public void selectAirline1() throws InterruptedException
 {
	 driver.findElement(AirIndia1).click();
	 Thread.sleep(2000);
 }
 //Method to confirm flight
 public void bookflight() throws InterruptedException
 {
	 try {
	 driver.findElement(FlightBookButton).click();
	 Thread.sleep(2000);
	 }
	 catch(NoSuchElementException e)
	 {
		 System.out.println("NoSuchElementException occured");
	 }
 }
 //Method to click on book button
 public void BookButton() throws InterruptedException
 {
	 try {
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(BookButton).click();
	 }
	 catch(NoSuchElementException e)
	 {
		 System.out.println("NoSuchElementException");
	 }
	 //Thread.sleep(2000);
 }
//Method to click on book button
public void bookButton1() throws InterruptedException
{
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(BookButton1).click();
	 //Thread.sleep(2000);
}
 //Method to click on continue book button
 public void ContinueBtn() throws InterruptedException
 {
	 try {
//	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ContinueButton));
	 driver.findElement(ContinueButton).click();
	 }
	 catch(NoSuchElementException e)
	 {
		 System.out.println("NoSuchElementException");
	 }
 }
 //Method to click on confirm button
 public void ConfirmButton1() throws InterruptedException
 {
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 driver.findElement(ContinueButton1).click();
 }
 //Method to switch window
 public void SwitchWindow()
 {
	 Set<String> window = driver.getWindowHandles();
	 for(String w : window)
	 {
		 driver.switchTo().window(w);
	 }
 }
 //Method to scroll
 public void scroll1()
 {
	 WebElement Element = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[4]/div/div/p"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", Element);
 }
 //Method to scroll traveller details
 public void scroll2()
 {
	 WebElement Element = driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div/form/div/div/div[4]/div/div/div/div/h2"));
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", Element);
 }
 //Method to enter mobile number
 public void enterMobileNumber(String value) throws InterruptedException
 {
	 Thread.sleep(2000);
	 driver.findElement(MobileNumber).sendKeys(value);
 }
 //Method to enter email
 public void enterEmail(String value) throws InterruptedException
 {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Email));
	 driver.findElement(Email).sendKeys(value);
 }
 //Method to select email
 public void SelectEmail()
 {
	 Actions action = new Actions(driver);
	 WebElement EmailDropdown1 = driver.findElement(EmailDropdown);
	 action.clickAndHold(EmailDropdown1).build().perform();
	 action.moveToElement(EmailDropdown1).build().perform();
	 action.click(EmailDropdown1).build().perform();
 }
 //Method to click on confirm button
 public void ConfirmButton() throws InterruptedException
 {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConfirmButton));
	 driver.findElement(ConfirmButton).click();
 }
 //Method to click on traveller continue button
 public void TravellerContinueButton() throws InterruptedException
 {
	 Thread.sleep(2000);
	 driver.findElement(TravellerContinueButton).click();
 } 
}




























