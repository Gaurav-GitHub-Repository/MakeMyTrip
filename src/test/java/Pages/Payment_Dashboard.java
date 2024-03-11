package Pages;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Payment_Dashboard {

	WebDriver driver;
	
	static org.apache.logging.log4j.Logger log = LogManager.getLogger(Payment_Dashboard.class.getName());
	
	public Payment_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator for proceed to pay button
	By ProceedToPay = By.xpath("//button[text()='Proceed to pay']");
	//Locator for card number
	By CardNumber = By.xpath("//input[@id='cardNumber' and @placeholder='Enter Your Card Number Here']");
	//Locator for card name
	By CardName = By.xpath("//input[@id='nameOnCard' and @placeholder='Enter Your Name On Card']");
	//Locato for PayNow Button
	By PayNow = By.xpath("//button[@type='button' and @class='prime__btn   paynow__btn font16']");
	
	//Method to switch payment window
	public void SwitchToPaymentWindow()
	{
		Set<String> window = driver.getWindowHandles();
		for(String PaymentWindow : window)
		{
			driver.switchTo().window(PaymentWindow);
		}
	}
	//Method to click on proceed to pay button
	public void ProceedToButton() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(ProceedToPay).click();
	}
	//Method to enter card number
	public void enterCardNumber(String value) throws InterruptedException
	{
		driver.findElement(CardNumber).sendKeys(value);
		Thread.sleep(2000);
	}
	//Method to enter card number
	public void enterCardName(String value) throws InterruptedException
	{
		driver.findElement(CardName).sendKeys(value);
		Thread.sleep(2000);
	}
	//Method to select expiry month
	public void selectMonth() throws InterruptedException
	{
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name='expiryMonth']")));
		select.selectByVisibleText("December (12)");
		List<WebElement> var = select.getOptions();
		for(WebElement month: var)
		{
			if(month.equals("December (12)"))
			{
				System.out.println("December (12) expiry month is selected");
			}
		}
	}
	//Method to select year
	public void selectYear() throws InterruptedException
	{
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.xpath("//select[@name='Year']")));
		select.selectByVisibleText("2034");
		List<WebElement> var = select.getOptions();
		for(WebElement year: var)
		{
			if(year.equals("2034"))
			{
				System.out.println("2034 expiry year is selected");
			}
		}
	}
	//Method to click on pay now button
	public void Pay_Button() throws InterruptedException
	{
		driver.findElement(PayNow).click();
		Thread.sleep(2000);
	}
}
