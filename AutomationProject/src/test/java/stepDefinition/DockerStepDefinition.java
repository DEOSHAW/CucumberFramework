package stepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DockerStepDefinition extends BaseStepDefinition {
	
	@Given("^Docker portal is launched$")
	public void docker_portal_is_launched() throws Exception {
	    driver.get("https://www.docker.com/");
	}

	@When("^user seraches for keyword \"([^\"]*)\"$")
	public void user_seraches_for_keyword(String arg1) throws Exception {
	    driver.findElement(By.xpath("(//*[local-name()='svg'])[4]")).click();
	    driver.findElement(By.xpath("//*[@id='searchText']")).sendKeys("Testing");
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
	}

	@Then("^the top result is displayed$")
	public void the_top_result_is_displayed() throws Exception {
	    WebElement result=driver.findElement(By.xpath("//*[contains(text(),'Search results')]/following::p[1]"));
	    System.out.println(result.getText());
	    js.executeScript("arguments[0].style.border='3px solid red'", result);
	    Thread.sleep(2500);
	}



}
