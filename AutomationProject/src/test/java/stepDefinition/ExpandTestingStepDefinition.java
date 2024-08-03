package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExpandTestingStepDefinition extends BaseStepDefinition
{
	@Given("Expand Testing portal is open")
	public void expand_testing_portal_is_open()
	{
		driver.get("https://practice.expandtesting.com/");
	    
	}
	@When("User navigates to Dynamic table page")
	public void user_navigates_to_dynamic_table_page() 
	{
		driver.findElement(By.xpath("//a[@href='/dynamic-table']")).click();
	    
	}
	@Then("Table values are printed in the console for Chrome")
	public void table_values_are_printed_in_the_console_for_chrome() 
	{
		String xpath="//table/tbody/tr[%s]";
		xpath=String.format(xpath, 1);
		System.out.println("Xpath is: "+xpath);
		String text=driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("MB"));
		
	    
	}


}
