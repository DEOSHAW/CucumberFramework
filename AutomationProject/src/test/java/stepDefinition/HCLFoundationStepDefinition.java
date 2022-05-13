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

public class HCLFoundationStepDefinition extends BaseStepDefinition {
	
	@Given("^HCL Foundation portal is launched$")
	public void hcl_Foundation_portal_is_launched() throws Exception {
	    driver.get("https://www.hclfoundation.org/");
	}

	@When("^user searches for below$")
	public void user_searches_for_below(DataTable dataTable) throws Exception {
	    List<List<String>> data=dataTable.asLists(String.class);
	   String keyWord= data.get(0).get(0);
	   Robot robot=new Robot();
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_F);
	   StringSelection str=new StringSelection(keyWord);
	  Clipboard cb= Toolkit.getDefaultToolkit().getSystemClipboard();
	  cb.setContents(str, null);
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_V);
	   Thread.sleep(2000);
	   robot.keyPress(KeyEvent.VK_ENTER);
	}

	@Then("^the search result is displayed on HCL Foundation portal$")
	public void the_search_result_is_displayed_on_HCL_Foundation_portal() throws Exception {
		
		WebElement destElement=driver.findElement(By.xpath("//*[text()='Focus work areas']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", destElement);
		Thread.sleep(2000);
	    
	}



}
