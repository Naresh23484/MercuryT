package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {



	WebDriver driver=null;
	public HomePageObjects(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	


	public void goTomercuryURL()
	{
		driver.get("http://www.newtours.demoaut.com/");
	}
	
}
