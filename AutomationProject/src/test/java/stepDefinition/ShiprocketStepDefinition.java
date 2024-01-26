package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShiprocketStepDefinition extends BaseStepDefinition
{
	@Given("Shiprocket portal is open")
	public void shiprocket_portal_is_open()
	{
	    driver.get("https://www.shiprocket.in/");
	}
	@When("User searches for below term")
	public void user_searches_for_below_term(io.cucumber.datatable.DataTable dataTable) throws Exception
	{
	    List<Map<String,String>> dataList=dataTable.asMaps(String.class,String.class);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    StringSelection str=new StringSelection(dataList.get(0).get("Term2"));
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	@Then("search result on Shiprocket portal is displayed")
	public void search_result_on_shiprocket_portal_is_displayed() throws InterruptedException 
	{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", driver.findElement(By.tagName("h2")));
		Thread.sleep(3000);
	   
	}




}
