package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenTextStepDefinition extends BaseStepDefinition {
	String parentWindow=null;
	@Given("^Open text portal is launched$")
	public void open_text_portal_is_launched() throws Exception {
	    driver.get("https://www.opentext.com/");
	}

	@When("^user clicks on managed services$")
	public void user_clicks_on_managed_services() throws Exception {
	    WebElement servicesLabel=driver.findElement(By.xpath("//h3[text()='Services']"));
	    js.executeScript("arguments[0].scrollIntoView();", servicesLabel);
	    WebElement DivArea=driver.findElement(By.xpath("(//*[@class='ot-footer__directory-list'])[2]"));
	    parentWindow= driver.getWindowHandle();
	    String keysToPress=Keys.chord(Keys.CONTROL,Keys.ENTER);
	    driver.findElement(By.xpath("(//*[text()='Managed Services'])[2]")).sendKeys(keysToPress);
	    Thread.sleep(1000);
	}

	@When("^user switches to managed services window$")
	public void user_switches_to_managed_services_window() throws Exception {
	   Set<String> allWindows=driver.getWindowHandles();
	  Iterator<String> itr= allWindows.iterator();
	  while(itr.hasNext())
	  {
		  String currentWindow=itr.next();
		  if(!parentWindow.equalsIgnoreCase(currentWindow))
		  {
			  driver.switchTo().window(currentWindow);
			  break;
		  }
	  }
	}

	@Then("^the overview is displayed$")
	public void the_overview_is_displayed() throws Exception {
	    String overviewText=driver.findElement(By.xpath("(//*[@class='ot-section__text'])[1]")).getText();
	    js.executeScript("alert(arguments[0])", overviewText);
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1000);
	}

}
