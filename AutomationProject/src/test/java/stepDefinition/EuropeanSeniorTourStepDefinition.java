package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EuropeanSeniorTourStepDefinition extends BaseStepDefinition {
	
	@Given("^European Senior Tour portal is open$")
	public void european_Senior_Tour_portal_is_open() throws Exception {
	    
		driver.get("https://www.europeantour.com/legends-tour/");
	}

	@When("^User searches for trending tournament news$")
	public void user_searches_for_trending_tournament_news() throws Exception {
		
		String newsText=driver.findElement(By.xpath("//h1[@class='banner__title']")).getText();
		StringSelection str=new StringSelection(newsText);
		Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
	    cp.setContents(str, null);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(1500);
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(2000);
		
	    
	}

	@Then("^the tournament news is displayed$")
	public void the_tournament_news_is_displayed() throws Exception {
	   System.out.println("News displayed");
	}



}
