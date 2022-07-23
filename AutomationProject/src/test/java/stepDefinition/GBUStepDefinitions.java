package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GBUStepDefinitions extends BaseStepDefinition {
	@Given("^GBU portal is open$")
	public void gbu_portal_is_open() throws Exception {
	    driver.get("https://www.gbu.ac.in/");
	}

	@When("^user searches for below on GBU portal$")
	public void user_searches_for_below_on_GBU_portal(DataTable data) throws Exception {
		List<Map<String,String>> listOfMaps=data.asMaps(String.class,String.class);
		WebElement searchBox=driver.findElement(By.xpath("//*[@type='search']"));
		searchBox.sendKeys(listOfMaps.get(0).get("Term"));
	   actions.sendKeys(searchBox,Keys.ENTER).perform();
	   Thread.sleep(2500);
	}

	@When("^user clicks on one of the search links$")
	public void user_clicks_on_one_of_the_search_links() throws Exception {
	   
	   String parentWindow=driver.getWindowHandle();
	   WebElement GBULink=driver.findElement(By.xpath("(//*[text()='About Gautam Buddha University'])[1]"));
	   js.executeScript("arguments[0].scrollIntoView();",GBULink);
	   js.executeScript("arguments[0].click();",GBULink);
	   Set<String> allWindows=driver.getWindowHandles();
	   for(String currentWin:allWindows)
	   {
		   if(!currentWin.equalsIgnoreCase(parentWindow))
		   {
		   driver.switchTo().window(currentWin);
		   break;
		   }
	   }
	}

	@Then("^the result text is displayed$")
	public void the_result_text_is_displayed() throws Exception {
	   System.out.println(driver.findElement(By.xpath("//*[@class='mt-5']")).getText().replaceAll("<b>", ""));
	}



}
