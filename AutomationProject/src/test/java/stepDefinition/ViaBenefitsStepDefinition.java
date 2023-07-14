package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViaBenefitsStepDefinition extends BaseStepDefinition {
	
	@Given("^ViaBenefits portal is open$")
	public void viabenefits_portal_is_open() throws Exception {
	    driver.get("https://optimizeretireebenefits.com/");
	}

	@When("^User searches for below plan$")
	public void user_searches_for_below_plan(DataTable dataTable) throws Exception {
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F);
	   List<List<String>> DT= dataTable.asLists(String.class);
	   StringSelection str=new StringSelection(DT.get(0).get(0));
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
	   robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
	}

	@Then("^the plan is displayed$")
	public void the_plan_is_displayed() throws Exception {
		
		String text=driver.findElement(By.xpath("//strong[contains(text(),'Elevate Your Retiree Healthcare Benefits')]")).getText();
		System.out.println(text);
	    
	}



}
