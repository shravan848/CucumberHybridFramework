package stepDefinitions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accountsPage;
import pages.homePage;
import pages.registerPage;
//import junit.framework.Assert;

public class register {
		WebDriver driver=driverFactory.getDriver();	
		homePage hPage=new homePage(driver);
		registerPage rPage=new registerPage(driver);
		Logger log=LogManager.getLogger("register");
				
	 @Given("^User navigates to Register Account page$")
	    public void user_navigates_to_register_account_page() throws Throwable {
//	        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
//	        driver.findElement(By.linkText("Register")).click();
		  hPage.clickOnMyAccount();
		  hPage.selectRegisterOption();
		  }

	    @When("^User enters the details into below fields$")
	    public void user_enters_the_details_into_below_fields(DataTable data) throws Throwable {
	        Map<String, String> dataMap=data.asMap(String.class, String.class);
	        
//	        driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
//	        driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
//	        driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//	        driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//	        driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//	        driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	        rPage.enterFirstName(dataMap.get("firstName"));
	        rPage.enterLastName(dataMap.get("lastName"));
	        rPage.enterTelephone(dataMap.get("telephone"));
	        rPage.enterEmail(dataMap.get("email"));
	        rPage.enterPassword(dataMap.get("password"));
	        rPage.enterConfirmPassword(dataMap.get("password"));
	        
	    }
	    
	    @And("^User selects privacy policy$")
	    public void user_selects_privacy_policy() throws Throwable {
	    	//driver.findElement(By.xpath("//input[@name='agree']")).click();
	    	
	    	rPage.clickAgreeOption();
	    	
	    		
	    	
	    }
	    
	    @And("^User clicks on continue button$")
	    public void user_clicks_on_continue_button() throws Throwable {
	    	//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    	 		
	    		rPage.clickOnContinueButton();	    		
	    		    	
	    }
	    
	    @Then("^User account should get created successfully$")
	    public void user_account_should_get_created_successfully()  {
	       /* if(driver.findElement(By.cssSelector("div[id='content'] h1")).getText().contains("Your Account Has Been Created!"))
	        {
	        System.out.println("Your Account Has Been Created!");
	       }
	        else
	        {
	        	System.out.println("Warning: E-Mail Address is already registered!");
	        } */
	    	accountsPage aPage=new accountsPage(driver);
	    	if(aPage.accountCreationSuccessMessage())
	    		{
	    	        System.out.println("Your Account Has Been Created Successfully...!");
	    	       }
	    	        else
	    	        {
	    	        	warningDuplicateEmailMessage();
	    	        	//System.out.println("This E-Mail Address is already registered with us...plz try with new Email...!");
	    	        }
	    	}
	    
	   	@Then("^User should get a warning about duplicate email$")
	    public void user_should_get_a_warning_about_duplicate_email() throws Throwable {
	    	//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	        if(rPage.warningMessageDuplicateEmail())
	        {
	        	warningDuplicateEmailMessage();
	   		//System.out.println("This E-Mail Address is already registered..! please try with new email Address...");
	        }
	   	}

	    @When("^User dont enters the details into fields$")
	    public void user_dont_enters_the_details_into_fields() throws Throwable {
	        rPage.enterFirstName("");
	        rPage.enterLastName("");
	        rPage.enterEmail("");
	        rPage.enterTelephone("");
	        rPage.enterPassword("");
	        rPage.enterConfirmPassword("");
	        
	    }


	    @Then("^User should get proper warning messages for every mandatory field$")
	    public void user_should_get_proper_warning_messages_for_every_mandatory_field() throws Throwable {
	     Assert.assertEquals("Warning: You must agree to the Privacy Policy!", driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText());
	      //Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
	      Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
	      Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
	      Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
	      Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
	      Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
	      System.out.println("Displaying proper warning messages for every mandatory field");
	    }
	    @And("^User selects Yes for Newsletter$")
	    public void user_selects_yes_for_newsletter() throws Throwable {
	        //driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
	    	rPage.selectNewsLetterOptionYes();
	    }
	    private void warningDuplicateEmailMessage()
	    {
	    System.out.println("This E-Mail Address is already registered with us...plz try with new Email Address...!");
	    }

}
