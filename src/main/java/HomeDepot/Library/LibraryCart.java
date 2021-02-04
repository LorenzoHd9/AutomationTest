package HomeDepot.Library;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import HomeDepot.Controls.*;


public class LibraryCart {
	public WebDriver driver ;
    ControlsCart controls;
	
	public LibraryCart(WebDriver driverbase) {
		this.driver= driverbase;
	}
    
    public void GotoHome() {
    	
		String actualtitle = driver.getTitle();
		controls = new ControlsCart(driver);
		System.out.println(actualtitle);
    }
    
    public void search(String element) {
    	controls.txtSearch.sendKeys(element + Keys.ENTER);
    }
    
    public void close() {
    	driver.close();
    }
}
