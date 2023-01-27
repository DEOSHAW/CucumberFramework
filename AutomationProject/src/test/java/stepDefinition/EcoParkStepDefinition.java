package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EcoParkStepDefinition extends BaseStepDefinition {
	String activityName;
	@Given("^EcoPark portal is open$")
	public void ecopark_portal_is_open() throws Exception {
	   driver.get("https://ecoparknewtown.com/activities");
	}

	@When("^User searches for below activity$")
	public void user_searches_for_below_activity(DataTable data) throws Exception {
	    List<Map<String,String>> dataList=data.asMaps(String.class, String.class);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    activityName=dataList.get(0).get("Activity");
	    StringSelection str=new StringSelection(activityName);
	    Clipboard cp=Toolkit.getDefaultToolkit().getSystemClipboard();
	    cp.setContents(str, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(2000);
	    
	}

	@Then("^the activities are displayed$")
	public void the_activities_are_displayed() throws Exception {
	    List<WebElement> activitiesList=driver.findElements(By.xpath("//a[contains(@href,'https://ecoparknewtown.com/activities/')]/following-sibling::h2"));
	    for(WebElement activity:activitiesList)
	    {
	    	if(activity.getText().contains(activityName))
	    	{
	    		System.out.println(activity.getText());
	    	}
	    }
	}



}
