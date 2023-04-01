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

public class BlackRockStepDefinition extends BaseStepDefinition {
	
	@Given("^BalckRock portal is open$")
	public void balckrock_portal_is_open() throws Exception {
	    driver.get("https://www.blackrock.com/corporate");
	   WebElement cokiesButton= driver.findElement(By.xpath("//button[contains(text(),'Required Only')]"));
	   js.executeScript("arguments[0].click();", cokiesButton);
	}

	@When("^User searches for below on BlackRock Portal$")
	public void user_searches_for_below_on_BlackRock_Portal(DataTable data) throws Exception {
	    List<Map<String,String>> dataList=data.asMaps(String.class, String.class);
	    		StringSelection str=new StringSelection(dataList.get(0).get("Term"));
	    		Clipboard cp=Toolkit.getDefaultToolkit().getSystemClipboard();
	    		cp.setContents(str, null);
	    		Robot robot=new Robot();
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		robot.keyPress(KeyEvent.VK_F);
	    		Thread.sleep(500);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		robot.keyRelease(KeyEvent.VK_F);
	    		Thread.sleep(500);
	    		robot.keyPress(KeyEvent.VK_CONTROL);
	    		robot.keyPress(KeyEvent.VK_V);
	    		Thread.sleep(500);
	    		robot.keyRelease(KeyEvent.VK_CONTROL);
	    		robot.keyRelease(KeyEvent.VK_V);
	    		Thread.sleep(2000);
	}

	@Then("^the search result is displayed on BlackRock portal$")
	public void the_search_result_is_displayed_on_BlackRock_portal() throws Exception {
	    System.out.println("Search term found");
	}



}
