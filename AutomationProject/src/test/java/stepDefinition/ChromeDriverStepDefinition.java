package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChromeDriverStepDefinition extends BaseStepDefinition {
	String driverVersion;
	@Given("^Chromium portal is launched$")
	public void chromium_portal_is_launched() throws Exception {
	    driver.get("https://chromedriver.chromium.org/downloads");
	}

	@When("^User looks up for the latest driver version$")
	public void user_looks_up_for_the_latest_driver_version() throws Exception {
		
		driverVersion=driver.findElement(By.xpath("(//*[contains(text(),'please download')])[1]/parent::p/child::span[5]/a")).getText();
	   
	}

	@Then("^the driver version is displayed$")
	public void the_driver_version_is_displayed() throws Exception {
	    System.out.println(driverVersion);
	}



}
