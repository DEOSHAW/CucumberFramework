package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BoomiStepDefinition extends BaseStepDefinition 
{
	 String application;
	
	@Given("Boomi portal is open")
	public void boomi_portal_is_open()
	{
	    driver.get("https://boomi.com/");
	}
	
	@When("User seraches for below on Boomi portal")
	public void user_seraches_for_below_on_boomi_portal(DataTable dataTable)
	{
	   List<List<String>> dataList= dataTable.asLists(String.class);
	   application=dataList.get(1).get(1);
	   driver.findElement(By.xpath("(//div[@id='boomi-search-toggle-on'])[1]/*[local-name()='svg']")).click();
	   WebElement inputBox=driver.findElement(By.xpath("(//input[@class='boomi-search-field'])[1]"));
	   actions.sendKeys(inputBox, application).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).perform();
	}
	
	@Then("Search results is displayed on Boomi Portal")
	public void search_results_is_displayed_on_boomi_portal() 
	{
		WebElement searchResult=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='boomi-results-page-title']")));
		Assert.assertEquals(searchResult.getText(), "Search Results for: "+application);
	    
	}




}
