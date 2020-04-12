package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPageObjects {
	WebDriver driver=null;
	public SelectFlightPageObjects(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using ="(//input[@name='outFlight'])[2]")
	private WebElement depart_outflight;
	
	@FindBy(how=How.XPATH, using ="(//input[@name='inFlight'])[2]")
	private WebElement return_inflight;
	
	@FindBy(how=How.CSS, using ="input[name=reserveFlights][type=image]")
	private WebElement continueto;

	public void outFlight()
	{
		depart_outflight.click();
	}
	
	public void inFlight()
	{
		return_inflight.click();
	}
	
	public void continueBooking()
	{
		continueto.click();
	}
	
}

