package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarshMcLennanStepDefinition extends BaseStepDefinition {
	
	@Given("MarshMcLennan portal is open")
	public void marsh_mc_lennan_portal_is_open() 
	{
		
		driver.get("https://www.marshmclennan.com/");
	    
	}
	@When("User finds for below on MarshMcLennan portal")
	public void user_finds_for_below_on_marsh_mc_lennan_portal(io.cucumber.datatable.DataTable dataTable) throws AWTException, InterruptedException {
	    List<List<String>> dataList= dataTable.asLists(String.class);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    StringSelection str=new StringSelection(dataList.get(0).get(0));
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    Thread.sleep(3000);
	    
	}
	@Then("the search result is displayed")
	public void the_search_result_is_displayed() {
	  WebElement supplierElement= driver.findElement(By.xpath("//a[contains(text(),'Suppliers ')]"));
	  Assert.assertEquals(supplierElement.getCssValue("font-size"), "14px");
	  Assert.assertEquals(supplierElement.getCssValue("font-family"), "noto-sans");
	  
	}




}
