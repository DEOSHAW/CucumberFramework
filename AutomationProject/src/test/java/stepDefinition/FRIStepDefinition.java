package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FRIStepDefinition extends BaseStepDefinition
{
	static String emailId;
	@Given("FRI portal is open")
	public void fri_portal_is_open() 
	{
		driver.get("http://fridu.edu.in/");
	    
	}
	@When("User stores the email")
	public void user_stores_the_email() 
	{
		WebElement email=driver.findElement(By.xpath("//i[@class='fa fa-envelope']/following-sibling::a"));
		js.executeScript("arguments[0].scrollIntoView()", email);
		emailId=email.getText();
	    
	}
	@Then("email is validated successfully")
	public void email_is_validated_successfully() 
	{
		Assert.assertEquals(emailId, "enquires@fridu.edu.in");
	   
	}

}
