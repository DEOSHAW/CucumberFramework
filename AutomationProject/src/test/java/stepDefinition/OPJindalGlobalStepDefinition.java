package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OPJindalGlobalStepDefinition extends BaseStepDefinition
{
	static String searchTerm;
	@Given("OP Jindal Global portal is open")
	public void op_jindal_global_portal_is_open() {
	    driver.get("https://jgu.edu.in/");
	}
	@When("User Searches for below on OP Jindal portal")
	public void user_searches_for_below_on_op_jindal_portal(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> dataList=dataTable.asLists(String.class);
		searchTerm=dataList.get(0).get(1);
	    driver.findElement(By.cssSelector("input.search-field")).sendKeys(searchTerm);
	    driver.findElement(By.cssSelector("span.search-btn-icon")).click();
	}
	@Then("the search is done")
	public void the_search_is_done() {
		 String searchedFor=driver.findElement(By.xpath("(//input[@class='search-field'])[2]")).getAttribute("value");
		 Assert.assertEquals(searchedFor, searchTerm);
	}




}
