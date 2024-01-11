package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EtihadStepDefinition extends BaseStepDefinition
{
	
	@Given("Etihad portal is open")
	public void etihad_portal_is_open() {
	    driver.get("https://www.etihad.com/en-in/");
	}
	@Then("Url contains etihad")
	public void url_contains_etihad() {
	    String url=driver.getCurrentUrl();
	    Assert.assertEquals(url, "https://www.etihad.com/en-in/");
	    System.out.println("Page title is: "+driver.getTitle());
	}

}
