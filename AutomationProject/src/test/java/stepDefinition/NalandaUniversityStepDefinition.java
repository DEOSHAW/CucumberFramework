package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NalandaUniversityStepDefinition extends BaseStepDefinition
{
	WebElement Vision;
	
	@Given("Nalanda University portal is open")
	public void nalanda_university_portal_is_open()
	{
	    driver.get("https://nalandauniv.edu.in/");
	}
	@When("User navigates to the vision section")
	public void user_navigates_to_the_vision_section() 
	{
		Vision=driver.findElement(By.xpath("//p[contains(text(),'Vision statement')]"));
		js.executeScript("arguments[0].scrollIntoView();", Vision);
	    
	}
	@Then("Vision of Nalanda University is displayed")
	public void vision_of_nalanda_university_is_displayed() throws InterruptedException
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Pink')", Vision);
		Thread.sleep(3000);
		System.out.println(Vision.getText());
	    
	}




}
