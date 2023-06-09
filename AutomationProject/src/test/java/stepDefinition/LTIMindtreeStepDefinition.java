package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LTIMindtreeStepDefinition extends BaseStepDefinition {
	
	
	@Given("^LTIMindtree portal is open$")
	public void ltimindtree_portal_is_open() throws Exception {
		
		driver.get("https://www.ltimindtree.com/");
		System.out.println(driver.getTitle());
	    
	}

	@When("^User searches for below on the LTIMindtree portal$")
	public void user_searches_for_below_on_the_LTIMindtree_portal(DataTable data) throws Exception {
		
		List<List<String>> dataList=data.asLists(String.class);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		StringSelection str=new StringSelection(dataList.get(0).get(0));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		
		
	    
	}

	@Then("^the search result is displayed on LTIMindtree portal$")
	public void the_search_result_is_displayed_on_LTIMindtree_portal() throws Exception {
	    System.out.println("Total Employee count: "+driver.findElement(By.cssSelector("span.values.emp")).getText());
	}

}
