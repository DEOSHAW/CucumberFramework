package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FreshWorksStepDefinition extends BaseStepDefinition {
	
	@Given("^Freshworks portal is launched$")
	public void freshworks_portal_is_launched() throws Exception {
	   driver.get("https://www.freshworks.com/");
	}

	@Given("^user searches for a \"([^\"]*)\"$")
	public void user_searches_for_a(String Term) throws Exception {
	   Robot robot=new Robot();
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_F);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   robot.keyRelease(KeyEvent.VK_F);
	   Thread.sleep(1500);
	   
	   StringSelection str=new StringSelection(Term);
	   Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
	   cb.setContents(str, null); 
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   robot.keyRelease(KeyEvent.VK_V);
	   Thread.sleep(1500);
	}

	@Then("^the serach result for \"([^\"]*)\" is found$")
	public void the_serach_result_for_is_found(String Term) throws Exception {
	   if(driver.findElement(By.xpath("//*[text()='"+Term+"']")).isDisplayed())
	   {
		   System.out.println("*****"+driver.findElement(By.xpath("//*[text()='"+Term+"']")).getText()+"*****");
	   }
	}



}
