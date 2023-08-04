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

public class ABSStepDefinition extends BaseStepDefinition {
	
	
	@Given("^ABS portal is open$")
	public void abs_portal_is_open() throws Exception {
	    driver.get("https://www.amity.edu/abs/");
	}
	
	

	@Then("^Search result is displayed on ABS$")
	public void search_result_is_displayed_on_ABS() throws Exception {
	    String resultText=driver.findElement(By.xpath("(//p[contains(text(),'B-School')])[1]")).getText();
	    System.out.println(resultText);
	}
	
	@When("^User searches for below on ABS portal$")
	public void user_searches_for_below_on_ABS_portal(DataTable data) throws Exception {
		Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    List<List<String>> dataList=data.asLists(String.class);
	    StringSelection str=new StringSelection(dataList.get(0).get(0));
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    //Thread.sleep(1000);
	    //robot.keyPress(KeyEvent.VK_ENTER);
	    //robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
	    
	}



}
