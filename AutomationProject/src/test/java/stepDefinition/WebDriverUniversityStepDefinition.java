package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebDriverUniversityStepDefinition extends BaseStepDefinition
{
	private boolean courseDisplayed=false;
	@Given("User is on WebDriver University portal")
	public void user_is_on_web_driver_university_portal() {
	    driver.get("https://webdriveruniversity.com/index.html");
	}
	@When("user searches for below course on the university portal")
	public void user_searches_for_below_course_on_the_university_portal(io.cucumber.datatable.DataTable dataTable) throws Exception 
	{
		List<List<String>> dataList=dataTable.asLists(String.class);
		String courseToSearch=dataList.get(3).get(0);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_F);
		StringSelection str=new StringSelection(courseToSearch);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		courseDisplayed=true;
	}
	@Then("the course is displayed on the university portal")
	public void the_course_is_displayed_on_the_university_portal()
	{
		if(courseDisplayed)
		{
			 System.out.println("Course Displayed");
		}
	}


}
