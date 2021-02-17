package HomeDepot.Controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class objects_Registration {
	private WebDriver driver;
	public objects_Registration(WebDriver webdriver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "WC_AccountDisplay_Login_Popup_links_3")
	public WebElement r_RegistrationLink;
	
	@FindBy(how = How.ID,using = "WC_AccountDisplay_div_19")
	public WebElement r_account;
	
	@FindBy(how = How.ID,using ="WC_UserRegistrationAddForm_NameEntryForm_FormInput_firstName_1")
	public WebElement ud_Name;
	
	@FindBy(how = How.ID,using ="WC_UserRegistrationAddForm_NameEntryForm_FormInput_lastName_1")
	public WebElement ud_Lastname1;
	
	@FindBy(how = How.ID,using = "WC_UserRegistrationAddForm_NameEntryForm_FormInput_middleName_1_1")
	public WebElement ud_Lastname2;
	
	@FindBy(how = How.ID,using = "Male")
	public WebElement ud_MaleRadio;
	
	@FindBy(how = How.ID,using = "state")
	public WebElement ud_StateSelectList;
	
	@FindBy(how = How.ID,using = "namescity")
	public WebElement ud_CitySelectList;
	
	@FindBy(how = How.ID,using = "WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1")
	public WebElement ud_Phone;
	
	@FindBy(how = How.ID,using = "WC_UserRegistrationAddForm_FormInput_email1_In_Register_1")
	public WebElement ud_mail;
	
	@FindBy(how = How.ID, using ="WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1")
	public WebElement ud_pass;
	
	@FindBy(how = How.ID, using ="WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1")
	public WebElement ud_PassVerify;
	
	@FindBy(how = How.XPATH,using = "//div[@id='WC_UserRegistrationAddForm_terminos_div_10']/div/label")
	public WebElement ud_TyC;
	
	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_links_1")
	public WebElement ud_Go;
}
