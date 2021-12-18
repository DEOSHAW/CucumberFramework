package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GrofersStepDefinition extends BaseStepDefinition {
	
	@Given("^Grofers portal is launched$")
	public void grofers_portal_is_launched() throws Exception {
	    driver.get("https://blinkit.in/");
	}

	@When("^user searche for vegetables with \"([^\"]*)\"$")
	public void user_searche_for_vegetables_with(String searchTerm) throws Exception {
	    driver.findElement(By.xpath("//*[contains(text(),'Detect my location')]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='text-container subHeading']")));
	    WebElement searchBox=driver.findElement(By.xpath("//*[@placeholder='Search for products']"));
	     //js.executeScript("arguments[0].value=arguments[1]", searchBox,searchTerm);
	    searchBox.sendKeys(searchTerm);
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@placeholder='Search for products']/parent::div/child::button")).click();
	    
	}

	@Then("^the serach results are displayed$")
	public void the_serach_results_are_displayed() throws Exception {
		
		int count=driver.findElements(By.xpath("//*[@class='plp-product__name--box']")).size();
	    js.executeScript("alert(arguments[0])", "Total "+count+" results displayed");
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	   
	}



}
