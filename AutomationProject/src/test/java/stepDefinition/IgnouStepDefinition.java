package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IgnouStepDefinition extends BaseStepDefinition
{
	@Given("Ignou portal is open")
	public void ignou_portal_is_open() 
	{
	    driver.get("https://www.ignou.ac.in/");
	    driver.findElement(By.xpath("(//button[@class='btn-close'])[2]")).click();
	}
	@When("User navigates to contacts page")
	public void user_navigates_to_contacts_page() 
	{
	    driver.findElement(By.xpath("//i[@class='fa-solid fa-address-card']/..")).click();
	}
	@Then("Address of Ignou is displayed")
	public void address_of_ignou_is_displayed()
	{
		System.out.println(driver.findElement(By.xpath("//div[@id='pills-home']//div[@class='col-sm-3']")).getText());
	}




}
