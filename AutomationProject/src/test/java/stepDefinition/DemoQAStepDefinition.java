package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoQAStepDefinition extends BaseStepDefinition {
	
	List<WebElement> allOptions;
	
	@Given("^DemoQA portal is launched$")
	public void demoqa_portal_is_launched() throws Exception {
	   driver.get("https://demoqa.com/");
	}

	@When("^All the options are available$")
	public void all_the_options_are_available() throws Exception {
	    allOptions=driver.findElements(By.xpath("//*[@class='card-body']/h5"));
	}

	@Then("^the options are displayed$")
	public void the_options_are_displayed() throws Exception {
	   for(WebElement Option: allOptions) 
	   {
		   System.out.println(Option.getText());
	   }
	}

}
