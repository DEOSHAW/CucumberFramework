package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankAuStepDefinition extends BaseStepDefinition
{
	static String searchText;
	@Given("user is on AU bank portal")
	public void user_is_on_au_bank_portal() 
	{
	    driver.get("https://www.bankaust.com.au/");
	}
	
	@When("User searches for below on Au bank portal")
	public void user_searches_for_below_on_au_bank_portal(io.cucumber.datatable.DataTable dataTable) throws AWTException, InterruptedException
	{
		List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
		WebElement searchButton=driver.findElement(By.xpath("//div[contains(@class,'n4_nav1_end_search_icon')]//*[local-name()='svg'][1]"));
		searchButton.click();
		WebElement searchInputBox=driver.findElement(By.cssSelector("input#search"));
		searchText=dataList.get(1).get("Keyword");
		js.executeScript("arguments[0].value=arguments[1]", searchInputBox,searchText);
		searchInputBox.click();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@Then("correct result is displayed on AU bank portal")
	public void correct_result_is_displayed_on_au_bank_portal() 
	{
		String searchResult=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.st-ui-type-heading"))).getText();
	    Assert.assertTrue(searchResult.contains(searchText.toLowerCase()),"Search Results is not correct");
	}

}
