package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YssStepDefinition extends BaseStepDefinition
{
	@When("User is on YSS portal")
	public void user_is_on_yss_portal() {
	    driver.get("https://yssofindia.org/");
	}
	@When("User finds with below term on YSS portal")
	public void user_finds_with_below_term_on_yss_portal(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		WebElement searchBox=driver.findElement(By.xpath("(//input[@title='search'])[1]"));
		searchBox.sendKeys(dataList.get(0).get(0));
		searchBox.sendKeys(Keys.ENTER);
	    
	}
	@Then("search results are displayed on YSS portal")
	public void search_results_are_displayed_on_yss_portal()
	{
		String resultText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Search Results']")))
				.getText();
		Assert.assertEquals(resultText,"Search Results");
	}
}
