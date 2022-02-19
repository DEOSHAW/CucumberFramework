package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import cucumber.api.java.en.Given;

public class MultipleWindowsStepDefinition extends BaseStepDefinition {
	WebDriver newDriver;
	String parentWindow;
	@Given("^Portal1 is launched$")
	public void portal_is_launched() throws Exception {
	   driver.get("https://www.orangehrm.com/");
	   parentWindow=driver.getWindowHandle();
	   
	}

	@Given("^User performs operations in first window$")
	public void user_performs_operations_in_first_window() throws Exception {
	    String text=driver.findElement(By.xpath("//*[contains(text(),'Peace of mind is just a few clicks away')]")).getText();
	   System.out.println(text);
	}

	@Given("^user opens a new tab$")
	public void user_opens_a_new_tab() throws Exception {
		newDriver= driver.switchTo().newWindow(WindowType.TAB);
		newDriver.get("https://www.oracle.com/in/index.html");
		
	}

	@Given("^performs operation in the second window$")
	public void performs_operation_in_the_second_window() throws Exception {
		newDriver.findElement(By.xpath("(//*[@data-target='products'])[1]")).click();
		Thread.sleep(2000);
	}

	@Given("^user switches back to first window$")
	public void user_switches_back_to_first_window() throws Exception {
	   newDriver.switchTo().window(parentWindow);
	  WebElement logo= driver.findElement(By.xpath("//*[contains(@alt,'OrangeHRM Inc Logo')]"));
	  js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", logo);
	  Thread.sleep(2000);
	}



}
