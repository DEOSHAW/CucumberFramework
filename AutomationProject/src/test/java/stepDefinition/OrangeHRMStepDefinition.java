package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMStepDefinition extends BaseStepDefinition {
	
	@Given("^OrangeHRM portal is launched$")
	public void orangehrm_portal_is_launched() throws Exception {
	    driver.get("https://www.orangehrm.com/");
	}

	@When("^user types email id \"([^\"]*)\"$")
	public void user_types_email_id(String emailId) throws Exception {
	    WebElement emailTextBox=driver.findElement(RelativeLocator.with(By.xpath("//*[@placeholder='Email Address']"))
				.toLeftOf(By.xpath("//*[@class='home-tril-email-btn']")));
	    Thread.sleep(1000);
	    js.executeScript("arguments[0].value=arguments[1]", emailTextBox,emailId);
	}
	    
	@When("^user clicks on submit$")
	public void user_clicks_on_submit() throws Exception {
		driver.findElement(RelativeLocator.with(By.xpath("//*[@class='home-tril-email-btn']"))
				.toRightOf(By.xpath("//*[@placeholder='Email Address']"))).click();
		
		//*[@placeholder='Email Address']
		
		//*[@class='home-tril-email-btn']
	}
	    
	

	@Then("^registration page is displayed$")
	public void registration_page_is_displayed() throws Exception {
	    WebElement detailsText=driver.findElement(By.xpath("//*[contains(text(),'We just need a few more details.')]"));
	    wait.until(ExpectedConditions.visibilityOf(detailsText));
	    Thread.sleep(3000);
	}

}
