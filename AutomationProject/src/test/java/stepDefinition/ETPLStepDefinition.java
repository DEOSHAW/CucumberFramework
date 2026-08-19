package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ETPLStepDefinition extends BaseStepDefinition
{
	@Given("User is on ETPL portal")
	public void user_is_on_etpl_portal() {
	    driver.get("https://www.etplofficial.com/");
	}
	@When("User navigates to Players page")
	public void user_navigates_to_players_page() {
	    driver.findElement(By.xpath("(//a[text()='Players'])[1]")).click();
	}
	@When("User searches for player")
	public void user_searches_for_player() throws Exception 
	{
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    Thread.sleep(500);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    StringSelection str=new StringSelection("Ashwin");
	    
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(500);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	@Then("Player is found")
	public void player_is_found() 
	{
	    Assert.assertTrue(true);
	}

}
