package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PKLStepDefinition extends BaseStepDefinition {
	
	@Given("^PKL portal is open$")
	public void pkl_portal_is_open() throws Exception {
		
		driver.get("https://www.prokabaddi.com/");
	    
	}

	@When("^User seraches for below$")
	public void user_seraches_for_below(DataTable table) throws Exception {
		List<List<String>> data=table.asLists(String.class);
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_F);
		 robot.keyRelease(KeyEvent.VK_F);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 StringSelection str=new StringSelection(data.get(0).get(0));
		    Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
		    cp.setContents(str, null);
		    robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 Thread.sleep(1500);
	    
	}

	@Then("^the organizer's name is displayed$")
	public void the_organizer_s_name_is_displayed() throws Exception {
		WebElement organizerName=driver.findElement(By.cssSelector("img[alt='Mashal Sports']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", organizerName);
		Thread.sleep(2000);
	   
	}



}
