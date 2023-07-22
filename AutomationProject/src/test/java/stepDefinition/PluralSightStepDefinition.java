package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PluralSightStepDefinition extends BaseStepDefinition {
	WebElement objectiveTextElement;
	
	@Given("^PluralSight portal is open$")
	public void pluralsight_portal_is_open() throws Exception {
	    driver.get("https://www.pluralsight.com/");
	}

	@When("^User looks for pluralSight objective$")
	public void user_looks_for_pluralSight_objective() throws Exception {
	    objectiveTextElement=driver.findElement(By.cssSelector(".text-scroller-component.aem-component"));
	}

	@Then("^the PluralSight objective is displayed$")
	public void the_PluralSight_objective_is_displayed() throws Exception {
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Green')", objectiveTextElement);
	    Thread.sleep(2000);
	    System.out.println(objectiveTextElement.getText());
	}

}
