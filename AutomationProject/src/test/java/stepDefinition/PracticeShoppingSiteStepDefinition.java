package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PracticeShoppingSiteStepDefinition extends BaseStepDefinition
{
	
	@Given("Practice shopping site is open")
	public void practice_shopping_site_is_open()
	{
	    driver.get("https://practice.automationtesting.in/shop/");
	}
	@Then("all the books are displayed")
	public void all_the_books_are_displayed() throws InterruptedException
	{
		List<WebElement> allBooks=driver.findElements(By.cssSelector("ul.products.masonry-done>li"));
		for(WebElement book:allBooks)
		{
		js.executeScript("arguments[0].scrollIntoView();", book);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", book);
		Thread.sleep(500);
		}
	   
	}

}
