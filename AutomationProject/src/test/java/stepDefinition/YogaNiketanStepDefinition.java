package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YogaNiketanStepDefinition extends BaseStepDefinition
{
	@Given("Yoga Niketan portal is open")
	public void yoga_niketan_portal_is_open() 
	{
	    driver.get("https://www.yoganiketanashram.org/index.php");
	}
	@When("User clicks on Book Your Stay link")
	public void user_clicks_on_book_your_stay_link() 
	{
	    WebElement reservationMenuLink=driver.findElement(By.xpath("//a[contains(text(),'RESERVATION')]"));
	    WebElement bookStayLink=driver.findElement(By.xpath("//a[contains(text(),'Book Your Stay')]"));
	    actions.moveToElement(reservationMenuLink).click(bookStayLink).perform();
	}
	@Then("User is navigated to Book your stay page")
	public void user_is_navigated_to_book_your_stay_page()
	{
	    Assert.assertTrue(driver.getCurrentUrl().contains("book-your-stay"));
	    Assert.assertEquals(driver.getTitle(),"Book Your Stay","User not on book stay page!");
	}

}
