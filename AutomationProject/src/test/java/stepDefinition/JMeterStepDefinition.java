package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JMeterStepDefinition extends BaseStepDefinition
{
	@Given("JMeter portal is open")
	public void j_meter_portal_is_open() {
	driver.get("https://jmeter.apache.org/");
	}
	@When("User looks up for below keywords on Jmeter portal")
	public void user_looks_up_for_below_keywords_on_jmeter_portal(io.cucumber.datatable.DataTable dataTable) throws Exception
	{
	    List<List<String>> dataList=dataTable.asLists(String.class);
	    String searchTerm=dataList.get(0).get(0);
	    StringSelection str=new StringSelection(searchTerm);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    Thread.sleep(2000);
	    WebElement foundElement=driver.findElement(By.xpath("//li[text()='"+searchTerm+"']"));
	    js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", foundElement);
	    Thread.sleep(3000);
	}
	@Then("the keyword is found")
	public void the_keyword_is_found() {
	    System.out.println("Found");
	}




}
