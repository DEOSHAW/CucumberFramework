package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseraStepDefinition extends BaseStepDefinition
{
	List<List<String>> dataList;
	@Given("Coursera portal is open")
	public void coursera_portal_is_open() {
	    driver.get("https://www.coursera.org/");
	}
	@When("User searches for below on Coursera")
	public void user_searches_for_below_on_coursera(io.cucumber.datatable.DataTable dataTable) {
	    dataList=dataTable.asLists(String.class);
	    driver.findElement(By.xpath("//input[@aria-label='What do you want to learn?']")).sendKeys(dataList.get(0).get(0));
	    driver.findElement(By.cssSelector("button.search-button>div")).click();
	}
	@Then("the search result is displayed on Coursera")
	public void the_search_result_is_displayed_on_coursera() {
	    String resultText=driver.findElement(By.xpath("//div[@data-e2e='NumberOfResultsSection']")).getText();
	    Assert.assertTrue(resultText.contains(dataList.get(0).get(0)));
	}

}
