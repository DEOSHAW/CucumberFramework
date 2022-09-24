package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OWGRStepDefinition extends BaseStepDefinition {
	
	
	@Given("^OWGR portal is launched$")
	public void owgr_portal_is_launched() throws Exception {
	    driver.get("https://www.owgr.com/current-world-ranking");
	    driver.findElement(By.xpath("//button[contains(text(),'Accept All Cookies ')]")).click();
	}

	@When("^user navigates to mission section$")
	public void user_navigates_to_mission_section() throws Exception {
	    driver.findElement(By.xpath("//div[contains(text(),'ABOUT US')]")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'ABOUT OWGR ')]")).click();
	}

	@Then("^mission of OWGR is displayed$")
	public void mission_of_OWGR_is_displayed() throws Exception {
		js.executeScript("window.scrollBy(0,80)");
	    String mission=driver.findElement(By.xpath("//p[contains(text(),'The mission of the OWGR')]")).getText();
	    Thread.sleep(1000);
	    System.out.println(mission);
	}


}
