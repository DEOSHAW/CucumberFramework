package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TopCoderStepDefinition extends BaseStepDefinition {
	List<WebElement> Coders,Rating;
	@Given("^TopCoder portal is launched$")
	public void topcoder_portal_is_launched() throws Exception {
	    driver.get("https://www.topcoder.com/tc?module=AlgoRank");
	}

	@When("^User navigates to programmer rankings$")
	public void user_navigates_to_programmer_rankings() throws Exception {
		Coders= driver.findElements(By.xpath("//*[@class='stat']//tbody//tr//td[@class='value']/a"));
		Rating= driver.findElements(By.xpath("//*[@class='stat']//tbody//tr//td[@class='valueR']"));
	}

	@Then("^the top fifty programmers are displayed$")
	public void the_top_fifty_programmers_are_displayed() throws Exception {
	    if(Coders.size()==Rating.size())
	    {
	    	for(int i=0;i<Coders.size();i++)
	    	{
	    		System.out.println(Coders.get(i).getText()+"====>"+Rating.get(i).getText());
	    	}
	    }
	}



}
