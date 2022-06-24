package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Keys;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FIFARankingsStepDefinition extends BaseStepDefinition {
	
	@Given("^FIFA portal is launched$")
	public void fifa_portal_is_launched() throws Exception {
	    driver.get("https://www.fifa.com/fifa-world-ranking/men");
	}

	@When("^user searches for the rankings of below countries$")
	public void user_searches_for_the_rankings_of_below_countries(DataTable countryName) throws Exception {
		List<List<String>> countryNames=countryName.asLists(String.class);
	   Robot robot=new Robot();
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_F);
	   Thread.sleep(800);
	   robot.keyRelease(KeyEvent.VK_F);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   StringSelection ss = new StringSelection(countryNames.get(0).get(0));
	    Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
	    cp.setContents(ss, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(3000);
	    
	  
	   
	}

	@Then("^the ranking is displayed$")
	public void the_ranking_is_displayed() throws Exception {
	    System.out.println("Rankings displayed");
	}



}
