package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CyientStepDefinition extends BaseStepDefinition {
	
	@Given("^Cyient portal is open$")
	public void cyient_portal_is_open() throws Exception {
	    driver.navigate().to("https://www.cyient.com/");
	    driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
	}

	@When("^User navigates to capabilities section$")
	public void user_navigates_to_capabilities_section() throws Exception {
	    driver.findElement(By.xpath("(//span[string()='Capabilities'])[1]")).click();
	    Thread.sleep(5000);
	}

	@Then("^capabilities are displayed$")
	public void capabilities_are_displayed() throws Exception {
	  List<WebElement> segments= driver.findElements(By.xpath("//a[contains(@href,'https://www.cyient.com/capabilities')]"));
	    for(WebElement sg:segments)
	    {
	    	String capability=sg.getAttribute("href");
	    	int len=capability.length();
	    	
	    	//if(!sg.getText().isEmpty())
	    	System.out.println(capability.substring(42,len).replaceAll("l/", ""));
	    
	    }
	}

}

