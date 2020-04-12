package Test;
import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Data_Project.MercuryCredential;
import PageObjects.BookFlightPageObjects;
import PageObjects.FlightFinderPageObjects;
import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import PageObjects.RegisterPageObjects;
import PageObjects.SelectFlightPageObjects;
import Utility.ExcelUtility2;
import Utility.ScreenshotClass;
import Utility.WebDriverFactory;

public class MercuryTest2 {
	WebDriver driver=null;
	WebDriverFactory fac=null;
	HomePageObjects homeobj=null;
	RegisterPageObjects regobj=null;
	LoginPageObjects loginobj =null;
	FlightFinderPageObjects flightobj=null;
	SelectFlightPageObjects selectflightobj=null;
	BookFlightPageObjects bookflightobj=null;
	ExcelUtility2 excelutil1=null;
	ScreenshotClass screenshot=null;
	WebDriverWait wait = null;
	ExtentReports report=null;
	ExtentHtmlReporter htmlReporter=null;
	ExtentTest test=null;
	Robot rob= null;

	@BeforeSuite
	public void startSuite() 
	{
		try {
			fac=WebDriverFactory.getinstanceOfWebDriverFactory();
			driver=fac.getDriver();	
			homeobj=new HomePageObjects(driver);
			regobj=new RegisterPageObjects(driver);
			loginobj=new LoginPageObjects(driver);
			flightobj=new FlightFinderPageObjects(driver);
			selectflightobj=new SelectFlightPageObjects(driver);
			bookflightobj=new BookFlightPageObjects(driver);
			excelutil1=new ExcelUtility2();
			screenshot=new ScreenshotClass();
			wait = new WebDriverWait(driver,5);
			rob=new Robot();
			htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/testReport.html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS","Windows");
			report.setSystemInfo("Browser","Chrome");

			//configuration items to change the look and feel
			//add content, manage tests etc
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Extent Report Demo");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void mercury_tours() throws Exception
	{
		//Extent report


		//getting details from user end and storing in a list  
		List<MercuryCredential> userMercuryDetails=null;
		userMercuryDetails=excelutil1.getMercuryDetails();
		for(MercuryCredential credential1 : userMercuryDetails)
		{
			test=report.createTest("Mercury"+credential1.getuName());
			driver.get("http://www.newtours.demoaut.com/");
			driver.manage().window().maximize();
			if(driver.getTitle().equals("Welcome: Mercury Tours"))
			{
				test.log(Status.PASS, "Successfully navigated to mercury");
			}
			else
			{
				test.log(Status.FAIL, "Couldn't connect to mercury");
			}

			// Mercury Home
			homeobj.goTomercuryURL();

			//Mercury Register
			regobj.mercuryRe();
			regobj.enterContactDetails(credential1.getFirstName(),credential1.getLastName(),credential1.getPhone(),credential1.getEmail());
			regobj.enterMailingDetails(credential1.getAddress(),credential1.getCity(),credential1.getState_province(),credential1.getPostalCode());
			regobj.countryDrop();
			regobj.countryDropDetails("INDIA");
			regobj.enterUserInforDetails(credential1.getuName(),credential1.getPassWord(), credential1.getConfirmpassWord());
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			screenshot.capture(driver, credential1.getFirstName()+"RegisterPage");
			regobj.mSubmitBtn();
			if(driver.getTitle().equals("Register: Mercury Tours"))
			{
				test.log(Status.PASS, "Successfully registered to mercury");
			}
			else
			{
				test.log(Status.FAIL, "Couldn't registered to mercury");
			}
			screenshot.capture(driver, credential1.getFirstName()+"Successfully Registered");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			regobj.mercuryRHome();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

			//login
			if(driver.getTitle().equals("Find a Flight: Mercury Tours: "))
			{
				test.log(Status.PASS, "Successfully redirect in to Mercury home");
			}
			else
			{
				test.log(Status.FAIL, "Failed to redirect to Mercury");
			}
			loginobj.enterLoginDetails(credential1.getuName(),credential1.getPassWord());
			loginobj.clickLoginBtn();
			screenshot.capture(driver, credential1.getuName());

			// finding flights
			flightobj.tripTypee();
			flightobj.departingFrom();
			flightobj.departingDetails("London");
			flightobj.arrivingIn();
			flightobj.arrivingDetails("Frankfurt");
			flightobj.returning();
			flightobj.returingMonth("October");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			screenshot.capture(driver, credential1.getFirstName()+"FlightFinder");
			flightobj.continueBooking();

			// selecting departing and returning flights
			selectflightobj.outFlight();
			selectflightobj.inFlight();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			screenshot.capture(driver, credential1.getFirstName()+"selected Flights");
			selectflightobj.continueBooking();

			// Booking Confirmation 
			bookflightobj.enterBookingDetails(credential1.getFirstName(),credential1.getLastName(), credential1.getNumber());
			bookflightobj.securepurchase();
			screenshot.capture(driver,credential1.getFirstName()+"bookingPage");

			//logging out
			loginobj.clickLogoutBtn();

		}

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown() {
		//to write or update test information to reporter
		report.flush();
	}

	@AfterSuite
	public void endSuite()
	{
		regobj=null;
		homeobj=null;
		loginobj=null;
		flightobj=null;
		selectflightobj=null;
		bookflightobj=null;
		screenshot=null;
		driver.close();
	}
}