package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreditSuisseStepDefinition extends BaseStepDefinition {
	
	@Given("^Credit suisse portal is launched$")
	public void credit_suisse_portal_is_launched() throws Exception {
	    driver.get("https://www.credit-suisse.com/in/en.html");
	    driver.findElement(By.xpath("//*[text()='Accept and continue']")).click();
	    Thread.sleep(1000);
	    
	}

	@When("^user searches for \"([^\"]*)\" on CreditSuisse Portal$")
	public void user_searches_for_on_CreditSuisse_Portal(String searchTerm) throws Exception {
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    StringSelection ss = new StringSelection(searchTerm);
	    Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
	    cp.setContents(ss, null);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	}

	@Then("^result is displayed$")
	public void result_is_displayed() throws Exception {
	    
	}



}
