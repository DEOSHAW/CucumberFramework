package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NasdaqStepDefinition extends BaseStepDefinition
{
	
	@Given("Nasdqa portal is open")
	public void nasdqa_portal_is_open() 
	{
	    driver.get("https://www.nasdaq.com/");
	}
	
	@When("User searches for below on Nasdaq portal")
	public void user_searches_for_below_on_nasdaq_portal(io.cucumber.datatable.DataTable dataTable) throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		List<List<String>> dataList=dataTable.asLists(String.class);
		
		StringSelection str=new StringSelection(dataList.get(1).get(0));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	
	    
	}
	
	@Then("result is displayed on Nasdaq portal")
	public void result_is_displayed_on_nasdaq_portal() 
	{
		String actualText=driver.findElement(By.xpath("//a[normalize-space(text())='Option Prices: 3 Things Investors Need to Know']")).getText();
	    Assert.assertTrue(actualText.contains("Investors"));
	}




}
