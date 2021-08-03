package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SAPLabStepDefinition extends BaseStepDefinition {
	JavascriptExecutor js;
	Actions actions;
	WebDriverWait wait;
	String result;
	
	@Given("^SAPLabs portal is launched$")
	public void saplabs_portal_is_launched() throws Exception {
	   driver.get("https://www.sap.com/india/about/company/innovation/labs.html");
	}

	@When("^user searches for products with \"([^\"]*)\"$")
	public void user_searches_for_products_with(String searchTerm) throws Exception {
		js=(JavascriptExecutor)driver;
		actions=new Actions(driver);
		wait=new WebDriverWait(driver, 15);
		driver.findElement(By.xpath("//*[contains(@class,'iconSearch')]")).click();
		WebElement searchBox=driver.findElement(By.xpath("//*[@placeholder='Search']"));
		searchBox.sendKeys(searchTerm);
	    //js.executeScript("arguments[0].value=arguments[1]",searchBox,searchTerm );
	    Thread.sleep(500);
	    actions.sendKeys(searchBox, Keys.ENTER).perform();
	    result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='search-result__bet'])[1]"))).getText();
	    
	}

	@Then("^the top search results is displayed$")
	public void the_top_search_results_is_displayed() throws Exception {
	    js.executeScript("alert(arguments[0])",result);
	    Thread.sleep(2800);
	    driver.switchTo().alert().accept();
	    Thread.sleep(500);
	}


}
