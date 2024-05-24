package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IndyCarStepDefinition extends BaseStepDefinition
{
	@Given("Indy Series portal is open")
	public void indy_series_portal_is_open() {
	    driver.get("https://www.indycar.com/");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.utilitarian__logo")));
	}
	@When("User searches for below on Indy Series portal")
	public void user_searches_for_below_on_indy_series_portal(DataTable dataTable) throws AWTException {
		List<Map<String,String>> dataList=dataTable.asMaps(String.class, String.class);
		String Keyword=dataList.get(0).get("Term2");
		Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_F);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    StringSelection str=new StringSelection(Keyword);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	}
	@Then("search result is displayed on Indy Series portal")
	public void search_result_is_displayed_on_indy_series_portal() throws InterruptedException
	{
		WebElement schedule=driver.findElement(By.xpath("//a[text()='Schedule']"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", schedule);
		Thread.sleep(3000);
	    
	}

}
