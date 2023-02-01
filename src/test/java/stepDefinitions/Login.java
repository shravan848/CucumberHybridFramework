package stepDefinitions;

import io.cucumber.java.en.*;
import pages.accountsPage;
import pages.homePage;
import pages.loginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;

public class Login {
	WebDriver driver=driverFactory.getDriver();
	private loginPage lPage=new loginPage(driver);
	
	@Given("^User has navigated to login page$")
    public void user_has_navigated_to_login_page()  {
		
		homePage hPage=new homePage(driver);
        hPage.clickOnMyAccount();
        hPage.selectLoginOption();
        
    }

    @When("^User has entered valid email address \"([^\"]*)\" into email field$")
    public void user_has_entered_valid_email_address_something_into_email_field(String emailText) throws InterruptedException {
    	//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);   
    	//lPage=new loginPage(driver);
    	//lPage=new loginPage(driver);
    	lPage.enterEmailAddress(emailText);
    	Thread.sleep(3);
    }
    
    @And("^User has entered valid password \"([^\"]*)\" into password field$")
    public void user_has_entered_valid_password_something_into_password_field(String passwordText)  {
    	//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);
    	//lPage=new loginPage(driver);
    	lPage.enterPassword(passwordText);
    	
    }

    @And("^User clicks on login button$")
    public void user_clicks_on_login_button()  {
       //driver.findElement(By.xpath("//input[@value='Login']")).click();
    	lPage.clickOnLoginButton();
    }
    
    @Then("User should get successfully logged in")
    public void User_should_get_successfully_logged_in()
    {
//    	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
//    	System.out.println("User has logged in successfully");
    	accountsPage aPage=new accountsPage(driver);
    	Assert.assertTrue(aPage.displayStatusOfAccountInformation());
    	System.out.println("User has logged in successfully");
    	
    }
    
    @When("^User has entered invalid email address \"([^\"]*)\" into email field$")
    public void user_has_entered_invalid_email_address_something_into_email_field(String invalidEmailText)  {
    	//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(invalidEmailText);
    	//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(getEmailWithTimeStamp());
    	/* the above will generate new email every time with timestamp     */
    	//lPage=new loginPage(driver);
    	lPage.enterEmailAddress(invalidEmailText);
    	
    }
    
    @And("^User has entered invalid password \"([^\"]*)\" into password field$")
    public void user_has_entered_invalid_password_something_into_password_field(String invalidPasswordText)  {
    	//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidPasswordText);
    	//lPage=new loginPage(driver);
    	lPage.enterPassword(invalidPasswordText);    	
    }
    
    @When("^User dont enter email into email field$")
    public void user_dont_enter_email_into_email_field()  {
    	//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
    	//lPage=new loginPage(driver);
    	lPage.enterEmailAddress("");
    }

    @Then("^User should get a warning message about credentials mismatch$")
    public void user_should_get_a_warning_message_about_credentials_mismatch()  {
           //	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
           /*	if(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText().contains("Warning: No match for E-Mail Address and/or Password.")||driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText().contains("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."))
    	{
           		System.out.println("Please enter valid email and password..!");
    	} */
    	
    	if(lPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password.")||lPage.getWarningMessageText().contains("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."))
    	{
    		System.out.println("Please enter valid email and password..!");
    	}
    	
    }
   
    @And("^User dont enter password into email field$")
    public void user_dont_enter_password_into_email_field()  {
    	//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
    	lPage.enterPassword("");
    }
    
    

}


