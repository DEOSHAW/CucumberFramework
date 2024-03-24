package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NvidiaStepDefinition extends BaseStepDefinition
{
	
	@Given("Nvidia portal is open")
	public void nvidia_portal_is_open()
	{
	    driver.get("https://www.nvidia.com/en-in/");
	}
	@When("User searches for below on Nvidia portal")
	public void user_searches_for_below_on_nvidia_portal(DataTable dataTable) 
	{
		List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
		driver.findElement(By.cssSelector("svg.n24-icon.nav-search-icon")).click();
		driver.findElement(By.cssSelector("#search-terms")).sendKeys(dataList.get(1).get("Term"));
		driver.findElement(By.cssSelector("#search-terms")).sendKeys(Keys.ENTER);
	    
	}
	@Then("search result is displayed on Nvidia portal")
	public void search_result_is_displayed_on_nvidia_portal() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Most Relevant']")));
		System.out.println(driver.findElement(By.cssSelector("div.LinesEllipsis")).getText());
	    
	}




}
