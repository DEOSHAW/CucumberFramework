package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NatwestStepDefinition extends BaseStepDefinition {
	String careerText;
	@Given("^Natwest portal is launched$")
	public void natwest_portal_is_launched() throws Exception {
	    driver.get("https://www.natwestgroup.com/");
	}

	@When("^user clicks on Career$")
	public void user_clicks_on_Career() throws Exception {
		List<WebElement> cookiesElement=driver.findElements(By.xpath("(//*[text()='Allow all cookies'])[2]"));
		if(cookiesElement.size()>0)
		{
			cookiesElement.get(0).click();
		}
	   driver.findElement(By.xpath("(//span[text()='Careers'])[1]")).click();
	}

	@When("^user extracts the career information$")
	public void user_extracts_the_career_information() throws Exception {
	    WebElement careerElement=driver.findElement(By.xpath("(//*[contains(text(),'Strong relationships with')])[2]"));
	    js.executeScript("arguments[0].scrollIntoView();", careerElement);
	    careerText=careerElement.getText();
	    
	}

	@Then("^Career information is displayed$")
	public void career_information_is_displayed() throws Exception {
		Thread.sleep(2000);
	    System.out.println(careerText);
	}



}
