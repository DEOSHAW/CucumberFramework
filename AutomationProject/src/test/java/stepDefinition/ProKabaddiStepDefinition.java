package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProKabaddiStepDefinition extends BaseStepDefinition {
	
	@Given("^ProKabaddi portal is open$")
	public void prokabaddi_portal_is_open() throws Exception {
	    driver.get("https://www.prokabaddi.com/");
	    List<WebElement> closeButton=driver.findElements(By.cssSelector("div.modal-window button"));
	    wait.until(ExpectedConditions.visibilityOfAllElements(closeButton));
	    if(closeButton.size()>0)
	    {
	    	closeButton.get(0).click();
	    	Thread.sleep(500);
	    }
	}

	@When("^User searches for below$")
	public void user_searches_for_below(DataTable data) throws Exception {
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
	    List<Map<String,String>> dataList=data.asMaps(String.class, String.class);
	    StringSelection str=new StringSelection( dataList.get(0).get("Term"));
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	  
	    Thread.sleep(4000);
	   
	}

	@Then("^the result is displayed on Pro Kabaddi portal$")
	public void the_result_is_displayed_on_Pro_Kabaddi_portal() throws Exception {
		WebElement textElement=driver.findElement(By.cssSelector("h3.article-title"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", textElement);
		Thread.sleep(3000);
	}


}
