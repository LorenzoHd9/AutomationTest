package HomeDepot.Library;

import org.openqa.selenium.WebDriver;

import HomeDepot.Controls.ControlsStore;

public class LibraryStore {

	public WebDriver driver ;
	ControlsStore controls;
	
	public LibraryStore(WebDriver driverbase) {
		this.driver = driverbase;
	}
	
	
}
