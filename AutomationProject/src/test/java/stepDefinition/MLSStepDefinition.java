package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MLSStepDefinition extends BaseStepDefinition {
	WebElement textElement;
	@Given("^MLS portal is open$")
	public void mls_portal_is_open() throws Exception {
	    driver.get("https://www.mlssoccer.com/");
	}

	@When("^User searches for the new team$")
	public void user_searches_for_the_new_team() throws Exception {
		textElement=driver.findElement(By.xpath("//*[starts-with(text(),'MLS San Diego aims')]"));
	    String searchText=textElement.getText();
	    StringSelection str=new StringSelection(searchText);
	    System.out.println(searchText);
	    
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_F);
	    
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(2000);
	}

	@Then("^Search result for the new team is displayed$")
	public void search_result_for_the_new_team_is_displayed() throws Exception {
		
		
		js.executeScript("arguments[0].scrollIntoView();", textElement);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')",textElement );
		 Thread.sleep(2000);
	    
	}



}
