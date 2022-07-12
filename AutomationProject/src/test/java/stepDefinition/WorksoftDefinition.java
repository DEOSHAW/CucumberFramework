package stepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class WorksoftDefinition extends BaseStepDefinition {
	
	
	@Given("^Worksoft portal is launched$")
	public void worksoft_portal_is_launched() throws Throwable {
		   
		   driver.get("https://www.worksoft.com/");
	}

	@When("^User Searches for the worksoft product \"([^\"]*)\"$")
	public void user_Searches_for_the_worksoft_product(String arg1) throws Throwable {
		
		WebElement searchText=driver.findElement(By.xpath("//*[@placeholder='Search']"));
		js=(JavascriptExecutor)driver;
		searchText.clear();
		js.executeScript("arguments[0].value=arguments[1]", searchText,"Certify");
		actions=new Actions(driver);
		actions.sendKeys(searchText,Keys.ENTER).perform();
		
		
	}

	@When("^Search Result for Worksoft is Displayed$")
	public void search_Result_for_Worksoft_is_Displayed() throws Throwable {
		
		String text=driver.findElement(By.xpath("(//*[@class='hs-search-results__description'])[1]/preceding-sibling::a")).getText();
	    Assert.assertEquals(text, "Certify® Automated Testing | Codeless Test Automation");
	    driver.close();
	    
	}



}
