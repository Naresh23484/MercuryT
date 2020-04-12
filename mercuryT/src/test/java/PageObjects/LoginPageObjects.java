package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {



	WebDriver driver=null;

	public LoginPageObjects(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.NAME, using ="userName")
	private WebElement userfield;

	@FindBy(how=How.NAME, using ="password")
	private WebElement passfield;

	@FindBy(how=How.CSS, using ="input[name=login][type=image]")
	private WebElement loginbtn;
	
	@FindBy(how=How.XPATH, using ="(//table/tbody/tr/td/a/img)[3]")
	private WebElement logoutbtn;


	public void enterLoginDetails(String user, String pass)
	{

		userfield.sendKeys(user);
		passfield.sendKeys(pass);
	}

	public void clickLoginBtn()
	{
		loginbtn.click();
	}
	public void clickLogoutBtn()
	{
		logoutbtn.click();
	}

}

