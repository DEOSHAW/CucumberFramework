package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JaneStreetStepDefinition extends BaseStepDefinition {
	
	@Given("^Jane Street portal is open$")
	public void jane_Street_portal_is_open() throws Exception {
	    driver.get("https://www.janestreet.com/");
	}

	@When("^User navigates to the recruitment message$")
	public void user_navigates_to_the_recruitment_message() throws Exception {
	   WebElement workWithUsText=driver.findElement(By.xpath("//h2[text()='Work with us']"));
	   js.executeScript("arguments[0].scrollIntoView();", workWithUsText);
	}

	@Then("^the recruitment message is displayed$")
	public void the_recruitment_message_is_displayed() throws Exception {
		
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", driver.findElement(By.xpath("//h2[text()='Work with us']/following::p[1]")));
	    Thread.sleep(2000);
	}



}
