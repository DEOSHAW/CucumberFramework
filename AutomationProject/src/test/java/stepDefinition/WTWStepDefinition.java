package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WTWStepDefinition extends BaseStepDefinition {
	
	
	@Given("^WTW portal is open$")
	public void wtw_portal_is_open() throws Exception {
	    driver.get("https://www.wtwco.com/en-IN");
	}

	@When("^User Searches for below keyword on WTW portal$")
	public void user_Searches_for_below_keyword_on_WTW_portal(DataTable data) throws Exception {
		
		List<List<String>> dataList=data.asLists(String.class);
	    driver.findElement(By.xpath("(//span[@data-eventcategory='Search Takeover Clicked'])[1]")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(dataList.get(1).get(1));
	    driver.findElement(By.xpath("//a[@aria-label='Search']")).click();
	}

	@Then("^the search result is displayed on WTW portal$")
	public void the_search_result_is_displayed_on_WTW_portal() throws Exception {
	   String text=driver.findElement(By.xpath("(//span[@class='CoveoExcerpt'])[1]")).getText();
	   System.out.println(text);
	   js.executeScript("alert(arguments[0])", text);
	   Thread.sleep(2000);
	   driver.switchTo().alert().accept();
	   Thread.sleep(1000);
	}



}
