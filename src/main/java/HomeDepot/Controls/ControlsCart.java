package HomeDepot.Controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class ControlsCart {
	WebDriver driver;
	public  ControlsCart(WebDriver driver) {
		 this.driver = driver;
	     PageFactory.initElements(driver, this);
	}

	@FindBy(id = "SimpleSearchForm_SearchTerm")
	public WebElement txtSearch;
	 
	 

}
