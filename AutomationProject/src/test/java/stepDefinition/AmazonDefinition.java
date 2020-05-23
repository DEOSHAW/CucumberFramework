package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utilitiesSelenium.UtilitiesClass;

public class AmazonDefinition {
	
	WebDriver driver=null;
	
	@Given("^Amazon portal is launched$")
	public void amazon_portal_is_launched() throws Throwable {
		driver=UtilitiesClass.LaunchBrowser(driver,"https://www.amazon.com");
	    
	}

	@When("^User Searches for the product \"([^\"]*)\"$")
	public void user_Searches_for_the_product(String product) throws Throwable {
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.SHIFT).perform();
		WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("Watches");
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div")).click();
		Thread.sleep(2000);
	    
	}

	@When("^Search Result is Displayed$")
	public void search_Result_is_Displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String searchResult=driver.findElement(By.xpath("//*[@id='search']/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
		Assert.assertEquals(searchResult, "\"WATCHES\"");
		driver.close();
	    
	}



}
