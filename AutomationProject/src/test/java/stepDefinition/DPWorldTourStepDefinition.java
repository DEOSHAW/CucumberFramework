package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DPWorldTourStepDefinition extends BaseStepDefinition
{
	WebElement privacyInformation;
	
	@Given("DP world tour portal is open")
	public void dp_world_tour_portal_is_open() {
	    driver.get("https://www.europeantour.com/dpworld-tour/");
	}
	@When("User extracts the privacy information")
	public void user_extracts_the_privacy_information() {
		privacyInformation=driver.findElement(By.xpath("(//a[@data-role='vlink'])[1]/parent::p"));
	}
	@Then("the privacy information is displayed")
	public void the_privacy_information_is_displayed() throws InterruptedException {
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", privacyInformation);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Agree & Close')]")).click();
		Thread.sleep(1000);
	}




}
