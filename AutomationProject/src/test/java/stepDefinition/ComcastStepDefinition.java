package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComcastStepDefinition extends BaseStepDefinition
{
	@Given("Comcast portal is open")
	public void comcast_portal_is_open() 
	{
	   driver.get("https://corporate.comcast.com/"); 
	}
	@When("User navigates to Environment page")
	public void user_navigates_to_environment_page()
	{
		WebElement impactElement=driver.findElement(By.xpath("//a[text()='Impact']"));
		WebElement environmentElement=driver.findElement(By.xpath("//a[text()='Environment']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(impactElement).pause(Duration.ofSeconds(2)).click(environmentElement).perform();
	    
	}
	@Then("Environment pledge is displayed")
	public void environment_pledge_is_displayed() 
	{
		String text=driver.findElement(By.xpath("//h3[text()='Carbon Neutral by 2035']/../p")).getText();
		System.out.println(text);
	    
	}




}
