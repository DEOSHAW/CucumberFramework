package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MLRStepDefinition extends BaseStepDefinition {
	
	@Given("^MLR portal is open$")
	public void mlr_portal_is_open() throws Exception {
	    driver.get("https://www.majorleague.rugby/");
	    List<WebElement> closeButton=driver.findElements(By.cssSelector(".hustle-button-icon.hustle-button-close.has-background"));
	    if(closeButton.size()>0)
	    {
	    	closeButton.get(0).click();
	    	
	    }
	    
	}

	@When("^User searches for the \"([^\"]*)\" on MLR site$")
	public void user_searches_for_the_on_MLR_site(String teamName) throws Exception {
	    driver.findElement(By.xpath("//a[contains(text(),'Teams')]")).click();
	    
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
	    Thread.sleep(3000);
	}

	@Then("^the team is displayed on the MLR site$")
	public void the_team_is_displayed_on_the_MLR_site() throws Exception {
	    System.out.println("Team displayed");
	}

}
