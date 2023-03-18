package stepDefinition;

import org.openqa.selenium.By;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class JavaTPointStepDefinition extends BaseStepDefinition {
	
	@Given("^JavaTPoint portal is open$")
	public void javatpoint_portal_is_open() throws Exception {
	    driver.get("https://www.javatpoint.com/");
	}

	@Then("^the list of latest JavaTPoint tutorials is displayed$")
	public void the_list_of_latest_JavaTPoint_tutorials_is_displayed() throws Exception {
	    for(int i=1;i<=15;i++)
	    {
	    	System.out.println(driver.findElement(By.xpath("(//*[text()='Latest Tutorials']/parent::fieldset//a//p)["+i+"]")).getText());
	    }
	}

}
