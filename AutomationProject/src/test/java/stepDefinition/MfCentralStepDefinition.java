package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MfCentralStepDefinition extends BaseStepDefinition
{
	WebElement quickLinkHeader;
	@Given("MF Central portal is open")
	public void mf_central_portal_is_open() {
	    driver.get("https://www.mfcentral.com/");
	}
	@When("User navigates to quick links section")
	public void user_navigates_to_quick_links_section() 
	{
		quickLinkHeader=driver.findElement(By.xpath("//div[@id='quick-links']//h2"));
		js.executeScript("window.scrollBy(0,3300)"); 
	}
	@Then("quick links are displayed")
	public void quick_links_are_displayed() throws InterruptedException
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid green; background:Red')", quickLinkHeader);
		Thread.sleep(3000);
	}

}
