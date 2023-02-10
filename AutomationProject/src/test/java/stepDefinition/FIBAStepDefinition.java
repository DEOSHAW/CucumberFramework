package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FIBAStepDefinition extends BaseStepDefinition {
	Robot robot;
	
	@Given("^FIBA portal is open$")
	public void fiba_portal_is_open() throws Exception {
	    driver.get("https://www.fiba.basketball/");
	}

	@When("^User searches for below on FIBA portal$")
	public void user_searches_for_below_on_FIBA_portal(DataTable table) throws Exception {
		robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		List<List<String>> data=table.asLists(String.class);
		String searchTerm=data.get(0).get(0);
		StringSelection st=new StringSelection(searchTerm);
		Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(st, null);
		
	    
	}

	@Then("^the result is displayed on FIBA portal$")
	public void the_result_is_displayed_on_FIBA_portal() throws Exception {
		
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2500);
		
	    
	}


	
	

}
