package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SailGPStepDefinition extends BaseStepDefinition {
	@Given("^SailGP portal is open$")
	public void sailgp_portal_is_open() throws Exception {
	    driver.get("https://sailgp.com/");
	    driver.findElement(By.xpath("//span[string()='Reject all cookies']")).click();
	    Thread.sleep(5000);
	}

	@When("^User searches for the SailGP team$")
	public void user_searches_for_the_SailGP_team(DataTable data) throws Exception {
	 List<Map<String, String>> dataList=data.asMaps(String.class, String.class);
	 String teamName=dataList.get(0).get("Team");
	 Robot robot=new Robot();
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_F);
	 robot.keyRelease(KeyEvent.VK_F);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 StringSelection str=new StringSelection(teamName);
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_V);
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 
	 
	}

	@Then("^the team details are displayed$")
	public void the_team_details_are_displayed() throws Exception {
	  WebElement teamDetails=driver.findElement(By.xpath("//table//tbody//div[text()='Australia']/parent::td/parent::tr"));
	  js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", teamDetails);
	  Thread.sleep(3000);
	}
}

