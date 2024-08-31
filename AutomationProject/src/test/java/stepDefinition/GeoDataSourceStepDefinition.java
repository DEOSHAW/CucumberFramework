package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeoDataSourceStepDefinition extends BaseStepDefinition
{
	@Given("GeoDataSource portal is open")
	public void geo_data_source_portal_is_open() 
	{
	   driver.get("https://www.geodatasource.com/software/country-region-dropdown-menu-demo");
	}
	@When("user searches for below on GeoDataSource portal")
	public void user_searches_for_below_on_geo_data_source_portal(io.cucumber.datatable.DataTable dataTable) throws Exception
	{
	    List<List<String>> dataList=dataTable.asLists(String.class);
	    StringSelection str=new StringSelection(dataList.get(0).get(1));
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    Thread.sleep(500);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(500);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(3000);
	    
	}
	@Then("the search result on GeoDataSource portal is displayed")
	public void the_search_result_on_geo_data_source_portal_is_displayed() 
	{
	    System.out.println("Displayed");
	}




}
