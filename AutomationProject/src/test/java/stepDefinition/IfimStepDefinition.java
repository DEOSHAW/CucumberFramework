package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IfimStepDefinition extends BaseStepDefinition
{
	@Given("IFIM portal is open")
	public void ifim_portal_is_open() 
	{
	    driver.get("https://ifim.edu.in/");
	}
	@When("User searches for below on IFIM portal")
	public void user_searches_for_below_on_ifim_portal(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(dataList.get(0).get(1));
		driver.findElement(By.cssSelector("button.elementor-search-form__submit")).click();
	    
	}
	
	@Then("Placement Result is displayed")
	public void placement_result_is_displayed()
	{
		String resultText=driver.findElement(By.xpath("//h2[text()='Search Results for: Placement Report']")).getText();
	    Assert.assertEquals(resultText, "Search Results For: Placement Report");
	}




}
