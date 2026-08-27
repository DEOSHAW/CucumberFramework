package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PfizerStepDefinition extends BaseStepDefinition
{
	@Given("User is on Pfizer portal")
	public void user_is_on_pfizer_portal() {
	    driver.get("https://www.pfizer.com/");
	}
	@When("User scrolls to the bottom of the Pfizer portal")
	public void user_scrolls_to_the_bottom_of_the_pfizer_portal() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	@Then("media handles are displayed")
	public void media_handles_are_displayed() {
	    List<WebElement> socialMediaList=driver.findElements(By.cssSelector("a.social-icon"));
	    for(int i=0;i<socialMediaList.size();i++)
	    {
	    	if(i==3)
	    		Assert.assertEquals(socialMediaList.get(i).getAttribute("aria-label"), "Instagram");
	    }
	}

}
