package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Dashboard {

	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(Dashboard.class.getName());
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for makemytrip logo
	By MakeMyTrip = By.xpath("//div[@id='root']/div/div/div/div/a/picture/img");
	//Locator for from city
	By FromCity = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div/label/span");
	//Locator for to city
	By ToCity = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/label/input");
	//Locator for from search 
	By FromLocation = By.xpath("//input[@type='text' and @placeholder='From']");
	//Locator to select from city airport	
	By FromAirport = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/ul/li/div/div/p[text()='Hyderabad, India']");
	//Locator for to search option 
	By ToAirport = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/span");
	//Locator for to city airport
	By ToLocation = By.xpath("//input[@type='text' and @placeholder='To']");
	//Locator for to airport
	By ToAirportCity = By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div/ul/li[2]/div/div/p[text()='New Delhi, India']");
	//Locator for Ad Button
	By AdButton = By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']");
	
	//Method to click on logo
	public void Logo()
	{
		driver.findElement(MakeMyTrip).click();
		log.info("Logo is verified");
	}
	//Method to click on from city
	public void FromCityOption()
	{
		driver.findElement(FromCity).click();
	}
	//Method to click on to city
	public void ToCityOption()
	{
		driver.findElement(ToCity).click();
	}
	//Method to fill from city
	public void SearchCity(String value)
	{
		driver.findElement(FromLocation).sendKeys(value);
	}
	//Method to select airport
	public void selectFromAirport() throws IOException
	{
		Actions action = new Actions(driver);
		WebElement Airport = driver.findElement(FromAirport);
		action.clickAndHold(Airport).build().perform();
		action.moveToElement(Airport).build().perform();
		action.click(Airport).build().perform();
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File targetfile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
		FileHandler.copy(sourcefile, targetfile);	
	}
	//Method to select airport
	public void selectToAirport()
	{
		driver.findElement(ToAirport).click();
	}
	//Method to select to city
	public void SearchToCity(String value)
	{
		driver.findElement(ToCity).sendKeys(value);
	}
	//Method to select airport
	public void selectToAirportCity() throws IOException
	{
		Actions action = new Actions(driver);
		WebElement Airport1 = driver.findElement(ToAirportCity);
		action.clickAndHold(Airport1).build().perform();
		action.moveToElement(Airport1).build().perform();
		action.click(Airport1).build().perform();
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File targetfile = new File("C:\\Users\\Gaurav\\Desktop\\Screenshot\\screenshot.png");
		FileHandler.copy(sourcefile, targetfile);	
	}
	//Method to close Ad 
	public void CloseAd()
	{
		try {
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.switchTo().frame(frame1);
		WebElement AdButton = driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		AdButton.click();
		}
		catch(ElementClickInterceptedException e)
		{
			System.out.println("ElementClickInterceptedException Exception occured");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("NoSuchElementException occured");
		}
	}
	//Method to refresh the page
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
}

