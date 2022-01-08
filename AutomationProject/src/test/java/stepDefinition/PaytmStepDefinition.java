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

public class PaytmStepDefinition extends BaseStepDefinition {
	
	@Given("^Paytm portal is launched$")
	public void paytm_portal_is_launched() throws Exception {
	    driver.get("https://paytm.com/");
	}

	@When("^user searches for \"([^\"]*)\" on paytm$")
	public void user_searches_for_on_paytm(String searchTerm) throws Exception {
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
	    robot.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    
	    
	}

	@Then("^the result is displayed on paytm$")
	public void the_result_is_displayed_on_paytm() throws Exception {
	    String text=driver.findElement(By.xpath("//h1[contains(text(),'Payments App')]")).getText();
	    System.out.println(text);
	}



}
