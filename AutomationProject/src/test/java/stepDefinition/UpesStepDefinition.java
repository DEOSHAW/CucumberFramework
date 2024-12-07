package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpesStepDefinition extends BaseStepDefinition
{
	@Given("UPES portal is open")
	public void upes_portal_is_open()
	{
	    driver.get("https://www.upes.ac.in/");
	}
	@When("User searches for below on the UPES portal")
	public void user_searches_for_below_on_the_upes_portal(DataTable dataTable)
	{
	    List<Map<String,String>> searchList=dataTable.asMaps(String.class, String.class);
	    driver.findElement(RelativeLocator.with(By.xpath("//button[@title='Search']"))
	    		.toRightOf(By.xpath("(//a[@title='Apply Now'])[1]"))).click();
	    WebElement searchInputBox=driver.findElement(By.cssSelector("input#header-search-input"));
	    searchInputBox.sendKeys(searchList.get(0).get("searchSecond"));
	    searchInputBox.sendKeys(Keys.ENTER);
	    
	    
	}
	@Then("search result is displayed")
	public void search_result_is_displayed() 
	{
	   boolean result=driver.findElement(By.cssSelector("div.search-result-wrap")).getText().contains("Search results for Placements");
	   Assert.assertTrue(result);
	}


}
