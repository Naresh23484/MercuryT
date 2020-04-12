package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects {
	WebDriver driver=null;
	public RegisterPageObjects(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using ="//a[contains(text(),'REGISTER')]")
	private WebElement registerbtn;
	
	@FindBy(how=How.NAME, using ="firstName")
	private WebElement Rfirstname;
	
	@FindBy(how=How.NAME, using ="lastName")
	private WebElement Rlastname;
	
	@FindBy(how=How.CSS, using ="input[name=phone]")
	private WebElement Rphone;

	@FindBy(how=How.NAME, using ="userName")
	private WebElement Remail;
	
	@FindBy(how=How.NAME, using ="address1")
	private WebElement Raddress;
	
	@FindBy(how=How.CSS, using ="input[name=city]")
	private WebElement Rcity;
	
	@FindBy(how=How.CSS, using ="input[name=state]")
	private WebElement Rstate;
	
	@FindBy(how=How.CSS, using ="input[name=postalCode]")
	private WebElement Rpostal;
	
	@FindBy(how=How.CSS, using ="select[name=country]")
	private WebElement Rcountry;
	
	@FindBy(how=How.CSS, using ="input[name=email]")
	private WebElement Rusername;
	
	@FindBy(how=How.CSS, using ="input[name=password]")
	private WebElement Rpassword;
	
	@FindBy(how=How.CSS, using ="input[name=confirmPassword]")
	private WebElement Rconpass;
	
	@FindBy(how=How.CSS, using ="input[name=register][type=image]")
	private WebElement Rsubmit;
	
	@FindBy(how=How.XPATH, using ="//a[contains(text(),'Home')]")
	private WebElement mhome;
	
	public void mercuryRe()
	{
		registerbtn.click();
	}
	
	public void enterContactDetails(String Fname, String Lname, String phone, String Email)
	{
		Rfirstname.sendKeys(Fname);
		Rlastname.sendKeys(Lname);
		Rphone.sendKeys(phone);
		Remail.sendKeys(Email);
	}
	public void enterMailingDetails(String add, String city, String state, String postalcode)
	{

		Raddress.sendKeys(add);
		Rcity.sendKeys(city);
		Rstate.sendKeys(state);
		Rpostal.sendKeys(postalcode);
		
	}
	public void countryDrop()
	{
		Rcountry.click();
	}
	
	public void countryDropDetails(String option)
	{
		driver.findElement(By.xpath("(//option[contains(text(),'"+option+"')])[3]")).click();
	}
	
	public void enterUserInforDetails(String uname, String passw, String conpassw)
	{
		Rusername.sendKeys(uname);
		Rpassword.sendKeys(passw);
		Rconpass.sendKeys(conpassw);
	}
	
	public void mSubmitBtn()
	{
		Rsubmit.click();
	}
	public void mercuryRHome()
	{
		mhome.click();
	}
	
}

