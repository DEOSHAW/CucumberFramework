package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HexawareStepdefinition extends BaseStepDefinition {
	List<WebElement> bannerElements;
	@Given("^Hexaware portal is launched$")
	public void hexaware_portal_is_launched() throws Exception {
	    driver.get("https://hexaware.com/");
	}

	@When("^user Extracts the text from the banners$")
	public void user_Extracts_the_text_from_the_banners() throws Exception {
		bannerElements=driver.findElements(By.xpath("//*[@class='banner-slider-data blk-83e']"));
	}

	@Then("^the texts are displayed$")
	public void the_texts_are_displayed() throws Exception {
		System.out.println(bannerElements.size());
	    for(WebElement banner:bannerElements)
	    {
	    	System.out.println(js.executeScript("return arguments[0].innerHTML;", banner));
	    	
	    	
	    }
	}



}
