package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {
	Select drop=null;
	public void dropdown(WebElement dropdownElement,String option) {
		drop=new Select(dropdownElement);
		drop.selectByVisibleText(option);

	}
}