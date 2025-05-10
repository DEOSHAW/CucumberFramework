package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RSAutomationStepDefinition extends BaseStepDefinition
{
	@Given("User is on RS portal")
	public void user_is_on_rs_portal() 
	{
	   driver.get("https://rahulshettyacademy.com/blog/index.php/automation-testing-interview-questions/"); 
	}
	@Then("page heading is highlighted")
	public void page_heading_is_highlighted() 
	{
	    WebElement pageHeading=driver.findElement(By.xpath("//span[contains(text(),'Automation Testing Interview Questions:')]"));
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", pageHeading);
	}

}
