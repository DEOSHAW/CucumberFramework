package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PublicisSapientStepDefinition extends BaseStepDefinition {
	
	@Given("^Publicis Sapient portal is launched$")
	public void publicis_Sapient_portal_is_launched() throws Exception {
	   driver.get("https://www.publicissapient.com/");
	}

	@When("^User Searches for \"([^\"]*)\" and \"([^\"]*)\" on Publicis Sapient portal$")
	public void user_Searches_for_and_on_Publicis_Sapient_portal(String Term1, String Term2) throws Exception {
	   
		String Term=Term1.concat(" "+Term2);
		
		StringSelection str=new StringSelection(Term);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1500);
		
	}

	@Then("^the Search result on Publicis Sapient portal is displayed$")
	public void the_Search_result_on_Publicis_Sapient_portal_is_displayed() throws Exception {
	    
	}



}
