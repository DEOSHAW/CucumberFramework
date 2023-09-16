package stepDefinition;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WPTStepDefinition extends BaseStepDefinition {
	
	@Given("WPT portal is open")
	public void wpt_portal_is_open() {
	    driver.get("https://worldpadeltour.com/");
	}
	@When("User clicks on WPT TV link")
	public void user_clicks_on_wpt_tv_link() throws InterruptedException {
		String parentWindow=driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'WPT TV')]"))).click();	    
		Set<String> allWindows=driver.getWindowHandles();
	    for(String Window:allWindows)
	    {
	    	if(!Window.equalsIgnoreCase(parentWindow))
	    	{
	    		driver.switchTo().window(Window);
	    		break;
	    	}
	    }
	}
	@When("User captures the image of WPT TV site")
	public void user_captures_the_image_of_wpt_tv_site() throws Exception {
		Assert.assertTrue(driver.getCurrentUrl().contains("worldpadeltourtv"), "Not Padel tour TV site");
		WebElement WptTVTextElement=driver.findElement(By.cssSelector("div.text-div"));
		wait.until(ExpectedConditions.visibilityOf(WptTVTextElement));
		File src=WptTVTextElement.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+File.separator+"WPT_TV.png"));
	    
	}
	@Then("the image gets captured and primary text is displayed")
	public void the_image_gets_captured_and_primary_text_is_displayed() {
	    System.out.println(driver.findElement(By.cssSelector("div.text-div")).getText());
	}




}
