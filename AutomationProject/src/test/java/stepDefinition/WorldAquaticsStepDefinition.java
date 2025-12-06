package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorldAquaticsStepDefinition extends BaseStepDefinition
{
	@Given("World Aquatics portal is open")
	public void world_aquatics_portal_is_open()
	{
	    driver.get("https://www.worldaquatics.com/");
	}
	@When("User searches for below on world aquatics portal")
	public void user_searches_for_below_on_world_aquatics_portal(io.cucumber.datatable.DataTable dataTable) throws Exception
	{
		List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		StringSelection str=new StringSelection(dataList.get(0).get("Keyword"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
	}
	@Then("the search result is displayed on the portal")
	public void the_search_result_is_displayed_on_the_portal() 
	{
		System.out.println("Search result is displayed");
	}

}
