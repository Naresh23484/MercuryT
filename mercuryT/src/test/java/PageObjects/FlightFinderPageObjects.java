package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightFinderPageObjects {
	WebDriver driver=null;
	public FlightFinderPageObjects(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.CSS, using ="input[name=tripType][value= oneway]")
	private WebElement tripType;
	
	@FindBy(how=How.XPATH, using ="//select[@name='fromPort']")
	private WebElement departing_dropdown;

	@FindBy(how=How.XPATH, using ="//select[@name='toPort']")
	private WebElement arrive_dropdown;
	
	@FindBy(how=How.XPATH, using ="//select[@name='toMonth']")
	private WebElement returning_Mdropdown;
	
	@FindBy(how=How.CSS, using ="input[name=findFlights][type=image]")
	private WebElement continueto;

	public void tripTypee()
	{
		tripType.click();
	}
	
	public void departingFrom()
	{
		departing_dropdown.click();
	}
	
	public void departingDetails(String option)
	{
		driver.findElement(By.xpath("(//option[contains(text(),'"+option+"')])[1]")).click();
	}
	
	public void arrivingIn()
	{
		arrive_dropdown.click();
	}
	
	public void arrivingDetails(String option)
	{
		driver.findElement(By.xpath("(//option[contains(text(),'"+option+"')])[2]")).click();
	}
	
	public void returning()
	{
		returning_Mdropdown.click();
	}
	
	public void returingMonth(String option)
	{
		driver.findElement(By.xpath("(//option[contains(text(),'"+option+"')])[2]")).click();
	}
	
	public void continueBooking()
	{
		continueto.click();
	}
	
}

