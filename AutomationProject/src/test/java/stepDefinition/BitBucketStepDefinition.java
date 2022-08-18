package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BitBucketStepDefinition extends BaseStepDefinition {
	
	@Given("^Bitbucket portal is open$")
	public void bitbucket_portal_is_open() throws Exception {
	    driver.get("https://bitbucket.org/product/");
	}

	@When("^user searches on Bitbucket for below$")
	public void user_searches_on_Bitbucket_for_below(DataTable data) throws Exception {
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    List<Map<String,String>> list=data.asMaps(String.class,String.class);
	    
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    
	    StringSelection str=new StringSelection(list.get(0).get("Term2"));
	    Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
	    cp.setContents(str, null);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(2000);
	    
	    
	    
	    
	    
	}

	@Then("^the serach result on Bitbucket is displayed$")
	public void the_serach_result_on_Bitbucket_is_displayed() throws Exception {
	 String overviewText= driver.findElement(By.xpath("(//*[contains(text(),'Bitbucket')])[1]")).getText();
	 System.out.println(overviewText);
	}



}
