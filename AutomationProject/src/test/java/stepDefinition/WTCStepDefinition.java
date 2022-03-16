package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WTCStepDefinition extends BaseStepDefinition {
	String rulesText;
	@Given("^WTC portal is launched$")
	public void wtc_portal_is_launched() throws Exception {
	   driver.get("https://www.cricbuzz.com/cricket-stats/points-table/test/world-test-championship-2021-2023");
	}

	@When("^user searches for the rules$")
	public void user_searches_for_the_rules() throws Exception {
	   rulesText=driver.findElement(By.xpath("//*[contains(text(),'In the WTC 2021-2023')]")).getText();
	}

	@Then("^the rules are displayed$")
	public void the_rules_are_displayed() throws Exception {
	   js.executeScript("alert(arguments[0])", rulesText);
	   Thread.sleep(3000);
	   driver.switchTo().alert().accept();
	   Thread.sleep(1000);
	}

}
