package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilitiesSelenium.UtilitiesClass;

public class TestRigorStepDefinition extends BaseStepDefinition
{
	@Given("TestRigor portal is open")
	public void test_rigor_portal_is_open()
	{
	   UtilitiesClass.LaunchBrowser("https://testrigor.com/", driver);
	}
	@When("User clicks on whyTestRigor link")
	public void user_clicks_on_why_test_rigor_link() 
	{
		driver.findElement(By.xpath("//a[string()='Why testRigor?']")).click();
	    
	}
	@Then("the reasons are displayed on the page")
	public void the_reasons_are_displayed_on_the_page()
	{
	    String text=driver.findElement(By.xpath("//h1/following-sibling::div[not(contains(@class,'buttons-block'))]")).getText();
	    System.out.println(text);
	}

}
