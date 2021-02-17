package HomeDepot.Library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import HomeDepot.Controls.objects_Registration;

public class LibraryRegistration {
	private WebDriverWait wait;
	private WebDriver driver;
	private objects_Registration registr = new objects_Registration(driver);
	
	public LibraryRegistration(WebDriver driverbase){
		this.driver = driverbase;
	}
	public void user_registration() throws Exception {
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(registr.ud_Name));
		registr.r_RegistrationLink.click();
		wait.until(ExpectedConditions.visibilityOf(registr.ud_Name));
		registr.ud_Name.click();
		registr.ud_Name.clear();
		registr.ud_Name.sendKeys((String) Utilities.getMapData("01_r"));
		
		registr.ud_Lastname1.click();
		registr.ud_Lastname1.clear();
		registr.ud_Lastname1.sendKeys((String)Utilities.getMapData("01_r2"));
		
		Select drpState = new Select(registr.ud_StateSelectList);
		drpState.selectByValue((String)Utilities.getMapData("01_r4"));
		Select dprCity = new Select(registr.ud_CitySelectList);
		dprCity.selectByValue((String) Utilities.getMapData("01_r5"));
		
		registr.ud_Phone.click();
		registr.ud_Phone.clear();
		registr.ud_Phone.sendKeys((String)Utilities.getMapData("01_r6"));
		
		registr.ud_mail.click();
		registr.ud_mail.clear();
		registr.ud_mail.sendKeys((String)Utilities.getMapData("01_r7"));
		
		registr.ud_pass.click();
		registr.ud_pass.clear();
		registr.ud_pass.sendKeys((String)Utilities.getMapData("01_r8"));
		
		registr.ud_PassVerify.click();
		registr.ud_PassVerify.clear();
		registr.ud_PassVerify.sendKeys((String) Utilities.getMapData("01_r9"));
		
		Utilities.scroll(registr.ud_Name);
		registr.ud_TyC.click();
		
	}
}
