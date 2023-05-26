package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CosmocodeStepDefinition extends BaseStepDefinition {
	String country;
	@Given("^Cosmocode portal is open$")
	public void cosmocode_portal_is_open() throws Exception {
	    driver.get("https://cosmocode.io/automation-practice-webtable/");
	}

	@When("^User searches for any of below countries$")
	public void user_searches_for_any_of_below_countries(DataTable table) throws Exception {
	    
		
		List<List<String>> data=table.asLists(String.class);
		country=data.get(1).get(2);
		
		
	}

	@Then("^the searched country is highlighted$")
	public void the_searched_country_is_highlighted() throws Exception {
		
		WebElement countryElement=driver.findElement(By.xpath("//table[@id='countries']//tr//td//strong[text()='"+country+"']"));
		
		js.executeScript("arguments[0].scrollIntoView();", countryElement);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", countryElement);
		
		Thread.sleep(2500);
	}



}
