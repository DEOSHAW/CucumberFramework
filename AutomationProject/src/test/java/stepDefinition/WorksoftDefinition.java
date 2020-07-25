package stepDefinition;

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

public class WorksoftDefinition {
	WebDriver driver=null;
	JavascriptExecutor js=null;
	Actions actions=null;
	
	@Given("^Worksoft portal is launched$")
	public void worksoft_portal_is_launched() throws Throwable {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   driver.get("https://www.worksoft.com/");
	}

	@When("^User Searches for the worksoft product \"([^\"]*)\"$")
	public void user_Searches_for_the_worksoft_product(String arg1) throws Throwable {
		
		WebElement searchText=driver.findElement(By.xpath("//*[@placeholder='Search']"));
		js=(JavascriptExecutor)driver;
		searchText.clear();
		js.executeScript("arguments[0].value=arguments[1]", searchText,"Certify");
		actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		
		
	}

	@When("^Search Result for Worksoft is Displayed$")
	public void search_Result_for_Worksoft_is_Displayed() throws Throwable {
		
		String text=driver.findElement(By.xpath("(//*[@class='hs-search-results__description'])[1]/preceding-sibling::a")).getText();
	    Assert.assertEquals(text, "Worksoft Certify® - #1 Codeless Automated Business Process Testing");
	    
	}



}
