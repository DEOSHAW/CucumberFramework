package stepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UdemyStepDefinition extends BaseStepDefinition {
	
	
	@Given("^Udemy portal is launched$")
	public void udemy_portal_is_launched() throws Exception {
	   
		driver.get("https://www.udemy.com/");
	}

	@When("^user types \"([^\"]*)\"$")
	public void user_types(String searchTerm) throws Exception {
	    WebElement searchBox=driver.findElement(By.xpath("//*[@placeholder='Search for anything']"));
	    //js.executeScript("arguments[0].value=arguments[1]", searchBox,searchTerm);
	    searchBox.sendKeys(searchTerm);
	    Thread.sleep(1500);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	}

	@Then("^the search result is displayed$")
	public void the_search_result_is_displayed() throws Exception {
		StringBuilder courseList=new StringBuilder();
		
		courseList.append("\n");
		for(int i=1;i<=5;i++)
		{
	   String courseName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class,'udlite-focus')])["+i+"]"))).getText();
		courseList.append(courseName);
		courseList.append("\n");
		
		}
		js.executeScript("alert('Top 5 Courses are: '+arguments[0])", courseList.toString());
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
	}


}
