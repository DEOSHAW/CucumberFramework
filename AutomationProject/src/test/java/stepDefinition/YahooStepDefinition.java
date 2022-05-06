package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YahooStepDefinition extends BaseStepDefinition {
	
	@Given("^Yahoo Portal is launched$")
	public void yahoo_Portal_is_launched() throws Exception {
	    driver.get("https://in.search.yahoo.com/");
	}

	@When("^User seraches for below Keywords$")
	public void user_seraches_for_below_Keywords(DataTable table) throws Exception {
	    List<List<String>> table1=table.asLists(String.class);
	    String searchKey=table1.get(0).get(0)+" "+table1.get(0).get(1);
	    driver.findElement(By.xpath("//*[@name='p']")).sendKeys(searchKey);
	}

	@Then("^the results are displayed$")
	public void the_results_are_displayed() throws Exception {
	    actions.sendKeys(Keys.ENTER).perform();
	   String courseText= wait.until(ExpectedConditions.presenceOfElementLocated(
	    		By.xpath("(//span[contains(normalize-space(string()),'Selenium For Beginners - Upto 60% Off on Select Titles')])[1]"))).getText();
	   
	   System.out.println("The result is: "+courseText);
	}



}
