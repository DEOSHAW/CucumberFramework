package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TricentisStepDefinition extends BaseStepDefinition {
	
	
	@Given("^Tricentis portal is launched$")
	public void tricentis_portal_is_launched() throws Exception {
	    driver.get("https://www.tricentis.com/");
	}

	@When("^User scrolls down to Information section$")
	public void user_scrolls_down_to_Information_section() throws Exception {
		
		WebElement infoSection=driver.findElement(By.xpath("//h3[text()='Technology you can trust']"));
	    js.executeScript("arguments[0].scrollIntoView()", infoSection);
	    
	    
	}

	@Then("^the information about tricentis is displayed$")
	public void the_information_about_tricentis_is_displayed() throws Exception {
		WebElement infoText=driver.findElement(By.xpath("//span[contains(text(),'leader in enterprise test automation')]"));
	    String text=(String) js.executeScript("return arguments[0].innerHTML", infoText);
	    js.executeScript("alert(arguments[0])", text);
	    Thread.sleep(2500);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	    
	}

}
