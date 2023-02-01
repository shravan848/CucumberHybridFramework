package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public String getWarningMessageText()
	{
		return warningMessage.getText();
	}

}
