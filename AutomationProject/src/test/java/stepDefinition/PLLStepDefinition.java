package stepDefinition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PLLStepDefinition extends BaseStepDefinition
{
	@Given("PLL portal is open")
	public void pll_portal_is_open() 
	{
	    driver.get("https://premierlacrosseleague.com/");
	    List<WebElement> closeButton=driver.findElements(By.cssSelector("span.uabb-modal-close"));
	    if(closeButton.size()>0)
	    {
	    	closeButton.get(0).click();
	    }
	}
	@When("user searches for below on PLL portal")
	public void user_searches_for_below_on_pll_portal(io.cucumber.datatable.DataTable dataTable) throws Exception
	{
       List<Map<String,String>> dataList=dataTable.asMaps(String.class,String.class);
       Robot robot=new Robot();
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_F);
       Thread.sleep(1000);
       robot.keyRelease(KeyEvent.VK_F);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(dataList.get(1).get("Conference")), null);
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       Thread.sleep(1000);
       robot.keyRelease(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       Thread.sleep(1000);
       WebElement conferenceLabel=driver.findElement(By.xpath("//th[text()='western']"));
       js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", conferenceLabel);
       
	}
	@Then("the search result is displayed on PLL portal")
	public void the_search_result_is_displayed_on_pll_portal() 
	{
	 
	}

}
