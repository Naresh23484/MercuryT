package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
	
	// declaring an instance of class WebDriverFactory which is null initially means not initialized.
	private static WebDriverFactory instanceOfWebDriverFactory=null;
	
	// Declaring constructor as private to restrict object creation outside of class
	private WebDriverFactory()
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/naresh.sunkari/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	// static method to create instance of class SingletonClassExample
	public static WebDriverFactory getinstanceOfWebDriverFactory()
	{
		if (instanceOfWebDriverFactory == null)
			instanceOfWebDriverFactory = new WebDriverFactory();

		return instanceOfWebDriverFactory;
	}
	public WebDriver driver;

	public WebDriver getDriver()
	{

		return driver;



	}


}
