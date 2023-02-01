package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.*;

public class search {
	WebDriver driver= driverFactory.getDriver();
	@Given("^User opens the application$")
    public void user_opens_the_application() throws Throwable {
		
    }

    @When("^User enter valid product \"([^\"]*)\" into search box field$")
    public void user_enter_valid_product_something_into_search_box_field(String validProductSearch) throws Throwable {
        driver.findElement(By.name("search")).sendKeys(validProductSearch);
    }
    
    @And("^User clicks on search button$")
    public void user_clicks_on_search_button() throws Throwable {
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    }

    @When("^User enters invlaid product \"([^\"]*)\" into search box field$")
    public void user_enters_invlaid_product_something_into_search_box_field(String invalidProductSearch) throws Throwable {
    	driver.findElement(By.name("search")).sendKeys(invalidProductSearch);
    }

    @When("^User dont enter any product name into search box field$")
    public void user_dont_enter_any_product_name_into_search_box_field() throws Throwable {
    	//Assert.assertEquals("There is no product that matches the search criteria.",driver.findElement(By.xpath("//input[@type='button']/following-sibling::p")).getText());
    driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
    }

    @Then("^User should get valid product displayed in search results$")
    public void user_should_get_valid_product_displayed_in_search_results() throws Throwable {
         Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
         System.out.println("HP Products are displayed...");
    }

    @Then("^User should get a message about no product matching$")
    public void user_should_get_a_message_about_no_product_matching() throws Throwable {
        Assert.assertEquals("There is no product that matches the search criteria.",driver.findElement(By.xpath("//input[@type='button']/following-sibling::p")).getText());
        System.out.println("There is no product that matches the search criteria.");
    }

    


}
