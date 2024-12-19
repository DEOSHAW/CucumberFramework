package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdmiralGroupStepDefinition extends BaseStepDefinition
{
	@Given("Admiral Group portal is open")
	public void admiral_group_portal_is_open()
	{
	   driver.get("https://admiralgroup.co.uk/"); 
	}
	@When("User navigates to our people section")
	public void user_navigates_to_our_people_section() throws InterruptedException
	{
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h2[text()='Our people']")));
	    Thread.sleep(1000);
	}
	@Then("our people information is displayed")
	public void our_people_information_is_displayed() 
	{
		System.out.println(driver.findElement(By.xpath("//h2[text()='Our people']/../p")).getText());
	    
	}

}
