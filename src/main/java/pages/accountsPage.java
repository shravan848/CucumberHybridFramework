package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class accountsPage  {
	WebDriver driver;
	public accountsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInformationOption;
	
	@FindBy(xpath="//div[@id='content']//following-sibling::h1")
	private WebElement accountCreationMessage;
	
	public boolean displayStatusOfAccountInformation()
	{
		return editAccountInformationOption.isDisplayed();
	}
	public boolean accountCreationSuccessMessage()
	{
		return accountCreationMessage.getText().contains("Your Account Has Been Created!");
	}
	

	}

