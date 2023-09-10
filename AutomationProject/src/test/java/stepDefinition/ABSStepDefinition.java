package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ABSStepDefinition extends BaseStepDefinition {
	
	
	@Given("ABS portal is open")
	public void abs_portal_is_open() {
		 driver.get("https://www.amity.edu/abs/");
	}
	@When("User searches for {string} on ABS portal")
	public void user_searches_for_on_abs_portal(String Keyword) throws Exception {
		Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    StringSelection str=new StringSelection(Keyword);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    //Thread.sleep(1000);
	    //robot.keyPress(KeyEvent.VK_ENTER);
	    //robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
	}
	@Then("Search result is displayed on ABS")
	public void search_result_is_displayed_on_abs() {
		String resultText=driver.findElement(By.xpath("(//p[contains(text(),'B-School')])[1]")).getText();
	    System.out.println(resultText);
	}



}
