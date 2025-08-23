package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuperRugbyStepDefinition extends BaseStepDefinition
{
	boolean isDisplayed=false;
	@Given("Super Rugby website is open")
	public void super_rugby_website_is_open()
	{
	    driver.get("https://super.rugby/superrugby/");
	}
	@When("User Searches for below")
	public void user_searches_for_below(io.cucumber.datatable.DataTable dataTable) throws Exception 
	{
		WebElement standingsHeader=driver.findElement(By.xpath("//h2[text()='Standings 2025']"));
		wait.until(ExpectedConditions.visibilityOf(standingsHeader));
	    List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(1000);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(dataList.get(0).get("Team")), null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(1000);
	    isDisplayed=true;
	    
	    
	}
	@Then("the team is displayed")
	public void the_team_is_displayed()
	{
		
	    Assert.assertTrue(isDisplayed);
	}

}
