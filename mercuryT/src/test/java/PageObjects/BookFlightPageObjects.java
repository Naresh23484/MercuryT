package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPageObjects {



	WebDriver driver=null;

	public BookFlightPageObjects(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.NAME, using ="passFirst0")
	private WebElement firstname_;

	@FindBy(how=How.NAME, using ="passLast0")
	private WebElement lastname_;

	@FindBy(how=How.NAME, using ="creditnumber")
	private WebElement creditnumber_;
	
	@FindBy(how=How.NAME, using ="buyFlights")
	private WebElement securePurchase;


	public void enterBookingDetails(String fname,String lname,double cnumber)
	{

		firstname_.sendKeys(fname);
		lastname_.sendKeys(lname);
		//creditnumber_.sendKeys();
	}

	public void securepurchase()
	{
		securePurchase.click();
	}

	
}
