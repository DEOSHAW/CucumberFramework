package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AnnaUniversityStepDefinition extends BaseStepDefinition
{
	@Given("Anna University portal is open")
	public void anna_university_portal_is_open() 
	{
	    driver.get("https://www.annauniv.edu/index.php#gsc.tab=0");
	}
	@When("User navigates to contact us page")
	public void user_navigates_to_contact_us_page()
	{
	   driver.findElement(By.xpath("(//a[text()='Contact Us'])[1]")).click();
	   System.out.println(driver.getTitle());
	}
	@Then("admission email is successfully validated")
	public void admission_email_is_successfully_validated()
	{
	    String emails=driver.findElement(By.xpath("//h3[text()='Email']/../child::p")).getText();
	    Assert.assertTrue(emails.contains("dircfa@annauniv.edu"),"Admission email not found");
	}
}
