package stepDefinition;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuessStepDefinition extends BaseStepDefinition {
	
	@Given("^Quess portal is launched$")
	public void quess_portal_is_launched() throws Exception {
	    driver.get("https://www.quesscorp.com/");
	}

	@When("^user scrolls down to services$")
	public void user_scrolls_down_to_services() throws Exception {
	    js.executeScript("window.scrollBy(0,250)");
	    
	}

	@Then("^the services offered by Quess gets highlighted$")
	public void the_services_offered_by_Quess_gets_highlighted() throws Exception {
		
		List<WebElement> allServices=driver.findElements(By.cssSelector(".srv-grid"));
		
		Iterator<WebElement> itr=allServices.iterator();
		while(itr.hasNext())
		{
			
			WebElement ele=itr.next();
			actions.moveToElement(ele).perform();
		    Thread.sleep(2000);
		}
	}



}
