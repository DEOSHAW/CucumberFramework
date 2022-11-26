package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CypressStepDefinition extends BaseStepDefinition{
	
	@Given("^Cypress portal is open$")
	public void cypress_portal_is_open() throws Exception {
	    driver.get("https://www.cypress.io/");
	}

	@Given("^User navigates to Pricing section$")
	public void user_navigates_to_Pricing_section() throws Exception {
	    driver.findElement(By.xpath("(//a[contains(@href,'pricing')])[2]")).click();
	}

	@Given("^User searches for pricing for below$")
	public void user_searches_for_pricing_for_below(DataTable data) throws Exception {
	   List<Map<String,String>> dataList=data.asMaps(String.class, String.class);
	   
	   Robot robot=new Robot();
	   Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
	   StringSelection str=new StringSelection(dataList.get(2).get("LicenseType"));
	   System.out.println(str);
	   cb.setContents(str, null);
	   
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_F);
	   robot.keyRelease(KeyEvent.VK_F);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   
	   
	   Thread.sleep(1000);
	   
	   
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_V);
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   
	   Thread.sleep(2000);
	   
	   robot.keyPress(KeyEvent.VK_ENTER);
	   robot.keyRelease(KeyEvent.VK_ENTER);
	   Thread.sleep(2000);
	   
	   
	   
	   
	}

	@Then("^the pricing for the searched license is displayed$")
	public void the_pricing_for_the_searched_license_is_displayed() throws Exception {
	    System.out.println("License fee displayed");
	}



}
