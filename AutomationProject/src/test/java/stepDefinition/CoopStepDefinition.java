package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CoopStepDefinition extends BaseStepDefinition {
	
	String successMessage;
	String errorMessage;
	
	@Given("^Coop website is launched$")
	public void coop_website_is_launched() throws Exception {
	    driver.get("http://coop.apps.symfonycasts.com/api");
	}

	@Given("^user Extracts the success and error response$")
	public void user_Extracts_the_success_and_error_response() throws Exception {
		successMessage=driver.findElement(By.xpath("//*[contains(text(),'Success Response')]//preceding-sibling::table//following-sibling::pre[1]")).getText();
		errorMessage=driver.findElement(By.xpath("//*[contains(text(),'Error Response')]//preceding-sibling::table//following-sibling::pre[2]")).getText();
	}

	@Then("^the same is displayed$")
	public void the_same_is_displayed() throws Exception {
		js.executeScript("alert(arguments[0])", successMessage);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		js.executeScript("alert(arguments[0])", errorMessage);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
	    
	}



}
