package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoforgeStepDefinition extends BaseStepDefinition {
	String searchTerm;
	
	@Given("^Coforge portal is launched$")
	public void coforge_portal_is_launched() throws Exception {
	   driver.get("https://www.coforge.com/");
	}

	@When("^User searches for the \"([^\"]*)\"$")
	public void user_searches_for_the(String Term) throws Exception {
		searchTerm=Term;
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_F);
	     StringSelection ss = new StringSelection(Term);
	    Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
	    cp.setContents(ss, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    
	}

	@Then("^the search result on Coforge site is displayed$")
	public void the_search_result_on_Coforge_site_is_displayed() throws Exception {
	    WebElement textElement=driver.findElement(By.xpath("//*[text()='"+searchTerm+"']"));
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", textElement);
	    Thread.sleep(2500);
	}

}
