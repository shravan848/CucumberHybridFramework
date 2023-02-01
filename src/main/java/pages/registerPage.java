package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
WebDriver driver;
public registerPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}
@FindBy(id="input-firstname")
private WebElement firstNameField;

@FindBy(id="input-lastname")
private WebElement lastNameField;

@FindBy(id="input-email")
private WebElement emailField;

@FindBy(id="input-telephone")
private WebElement telephoneField;

@FindBy(id="input-password")
private WebElement passwordField;

@FindBy(id="input-confirm")
private WebElement confirmPasswordField;

@FindBy(xpath="//input[@name='agree']")
private WebElement agreeOption;

@FindBy(xpath="//input[@value='Continue']")
private WebElement continueButton;

@FindBy(xpath="//div[contains(@class,'alert-danger')]")
private WebElement warningDuplicateEmail;

@FindBy(xpath="(//input[@name='newsletter'])[1]")
private WebElement selectNewsLetterOption;

public void enterFirstName(String firstName)
{
	firstNameField.sendKeys(firstName);
}

public void enterLastName(String lastName) 
{
	lastNameField.sendKeys(lastName);
}

public void enterEmail(String emailText) {
	emailField.sendKeys(emailText);
}
public void enterTelephone(String telephone) {
	telephoneField.sendKeys(telephone);
}
public void enterPassword(String password) {
 passwordField.sendKeys(password);
}
public void enterConfirmPassword(String password) {
	confirmPasswordField.sendKeys(password);
}
public void clickAgreeOption()
{
	agreeOption.click();
}
public void clickOnContinueButton()
{
	continueButton.click();
}
public boolean warningMessageDuplicateEmail()
{
	return warningDuplicateEmail.getText().contains("Warning: E-Mail Address is already registered!");
}
public void selectNewsLetterOptionYes()
{
	selectNewsLetterOption.click();
}

}
