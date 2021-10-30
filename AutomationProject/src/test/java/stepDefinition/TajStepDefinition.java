package stepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TajStepDefinition extends BaseStepDefinition {
	
	@Given("^Taj mahal official site is launched$")
	public void taj_mahal_official_site_is_launched() throws Exception {
	    driver.get("http://www.tajmahal.gov.in/visiting-hours.aspx");
	}

	@Given("^user clicks on VisitingHours link$")
	public void user_clicks_on_VisitingHours_link() throws Exception {
	    driver.findElement(By.xpath("(//a[@href='visiting-hours.aspx'])[1]")).click();
	}

	@Given("^user seraches for timing \"([^\"]*)\"$")
	public void user_seraches_for_timing(String searchKeyword) throws Exception {
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(1000);
	    
	    Actions actions=new Actions(driver);
	    actions.click().pause(200).sendKeys(searchKeyword).build().perform();
	    System.out.println(searchKeyword);
	    Thread.sleep(3000);
	    
	    
	    
	}

	@Then("^the visiting time is displayed$")
	public void the_visiting_time_is_displayed() throws Exception {
	  String timing= driver.findElement(By.xpath("(//*[@class='text_style_2 pt-0'])[1]")).getText();
	  System.out.println(timing);
	}



}
