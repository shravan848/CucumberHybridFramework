package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	WebDriver driver;
	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropdown;
	
	public void clickOnMyAccount()
	{
		myAccountDropdown.click();
	}
	
	@FindBy(linkText="Login")
	private WebElement login;
	
	public void selectLoginOption()
	{
		login.click();
	}
	@FindBy(linkText="Register")
	private WebElement register;
	
	public void selectRegisterOption()
	{
		register.click();
	}

	

}
