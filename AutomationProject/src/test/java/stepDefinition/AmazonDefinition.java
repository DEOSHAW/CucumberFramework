package stepDefinition;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilitiesSelenium.UtilitiesClass;

public class AmazonDefinition extends BaseStepDefinition{
	
	//WebDriver driver=null;
	JavascriptExecutor js=null;
	
	@Given("^Amazon portal is launched$")
	public void amazon_portal_is_launched() throws Throwable {
		driver.get("https://www.amazon.com");
	    
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
	
	@When("^Navigate to local currency page$")
	public void navigate_to_local_currency_page() throws Throwable {
		
		driver.findElement(By.cssSelector("i[class='a-icon a-icon-next-rounded']")).click();
		WebElement currencyLink=driver.findElement(By.cssSelector("img[alt='Click here to shop in your local currency']"));
		String imageText=currencyLink.getAttribute("alt");
		assertThat(imageText,is("Click here to shop in your local currency"));
		js=(JavascriptExecutor)driver;
		//driver.findElement(By.xpath("//*[@alt='Click here to shop in your local currency']/parent::a")).click();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@alt='Click here to shop in your local currency']/parent::a")));
		
	    
	}

	@Then("^Validate The presence of Indian Currency$")
	public void validate_The_presence_of_Indian_Currency() throws Throwable {
		
		String currencyText=driver.findElement(By.cssSelector("span#lop-select")).getText();
		assertThat(currencyText,is("Select the language you prefer for browsing, shopping, and communications."));
		driver.close();
	}





}