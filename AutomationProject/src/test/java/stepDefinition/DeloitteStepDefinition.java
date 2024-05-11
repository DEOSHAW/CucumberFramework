package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeloitteStepDefinition extends BaseStepDefinition
{
	@Given("Deloitte portal is open")
	public void deloitte_portal_is_open() 
	{
	    driver.get("https://www2.deloitte.com/us/en.html");
	    driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
	}
	@When("User searches for below on Deloitte portal")
	public void user_searches_for_below_on_deloitte_portal(DataTable dataTable) throws AWTException 
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		String searchTerm=dataList.get(0).get(0);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(searchTerm);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	    
	}
	@Then("Search result is displayed on Deloitte portal")
	public void search_result_is_displayed_on_deloitte_portal()
	{
		String searchResultHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))).getText();
		Assert.assertTrue(searchResultHeader.contains("Results for"));
		
	    
	}

}
