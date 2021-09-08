package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ServiceNowStepDefinition extends BaseStepDefinition {
	 String Text;
	@When("^User clicks on Get started link$")
	public void user_clicks_on_Get_started_link() throws Exception {
	   driver.get("https://www.servicenow.com/");
	   js.executeScript("arguments[0].click();", driver.findElement(By.linkText("Get Started")));
	}

	@When("^User extracts the details$")
	public void user_extracts_the_details() throws Exception {
	   WebElement text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@data-com-title,'Contact sales to start')]")));
	   Text= (String) js.executeScript("return arguments[0].innerHTML;", text);
	}

	@Then("^details are displayed$")
	public void details_are_displayed() throws Exception {
	  System.out.println(Text);  
	}


}
