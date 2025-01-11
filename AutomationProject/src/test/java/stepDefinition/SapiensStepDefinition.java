package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SapiensStepDefinition extends BaseStepDefinition
{
	@Given("Sapiens portal is open")
	public void sapiens_portal_is_open() 
	{
	    driver.get("https://sapiens.com/");
	    driver.findElement(By.cssSelector("button#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
	}
	@When("User searches for below")
	public void user_searches_for_below(io.cucumber.datatable.DataTable dataTable)
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		WebElement searchLink=driver.findElement(By.xpath("//a[@title='Search']"));
		wait.until(ExpectedConditions.elementToBeClickable(searchLink));
		js.executeScript("arguments[0].click();",searchLink );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='search'])[1]"))).sendKeys(dataList.get(0).get(0));
	    driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		
	}
	@Then("Search result is displayed on the Sapiens portal")
	public void search_result_is_displayed_on_the_sapiens_portal() throws InterruptedException
	{
		WebElement searchResult=driver.findElement(By.xpath("(//h2[@class='entry-title fusion-post-title'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", searchResult);
		Thread.sleep(2000);
	}




}
