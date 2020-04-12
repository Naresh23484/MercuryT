package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotClass {

	      public void capture(WebDriver driver,String uname) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	      File srcFile=ts.getScreenshotAs(OutputType.FILE);
	      File dir=new File("Screenshots");
	      if(dir.exists())
	      {
	    	  
	      }
	      else
	      {
	    	  dir.mkdir();
	      }
	      File destFile=new File("Screenshots/"+uname+".png");
	      //FileUtils.copyFile(srcFile,destFile);
	      FileHandler.copy(srcFile, destFile);
	      
	       
	               
	                     
	       
	    
	}
}
