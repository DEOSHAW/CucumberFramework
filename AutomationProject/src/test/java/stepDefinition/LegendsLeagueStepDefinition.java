package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LegendsLeagueStepDefinition extends BaseStepDefinition {
	WebElement broadcaster;
	@Given("^Legends League portal is open$")
	public void legends_League_portal_is_open() throws Exception {
	    driver.get("https://www.llct20.com/");
	}

	@When("^User navigates to broadcaster partner section$")
	public void user_navigates_to_broadcaster_partner_section() throws Exception {
		broadcaster=driver.findElement(By.xpath("//span[text()='Official Broadcaster']/following-sibling::img"));
	    js.executeScript("arguments[0].scrollIntoView();", broadcaster);
	}

	@Then("^the name of the broadcaster is displayed$")
	public void the_name_of_the_broadcaster_is_displayed() throws Exception {
		String officialBroadcaster=broadcaster.getAttribute("src")
				.replaceAll("https://www.llct20.com/images/sponsors/","").replaceAll(".png", "");
		System.out.println("Official Broadcaster: "+officialBroadcaster);
	    
	}



}
