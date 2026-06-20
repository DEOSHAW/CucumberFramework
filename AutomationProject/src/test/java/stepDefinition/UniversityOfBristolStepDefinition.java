package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UniversityOfBristolStepDefinition extends BaseStepDefinition
{
	@Given("University of Bristol portal is open")
	public void university_of_bristol_portal_is_open() 
	{
	   driver.get("https://www.bristol.ac.uk/"); 
	}
	@When("User searches for below course on Bristol portal")
	public void user_searches_for_below_course_on_bristol_portal(io.cucumber.datatable.DataTable dataTable) 
	{
	   WebElement CourseLevel= driver.findElement(By.cssSelector("select#study-level"));
	   Select CourseLevelDropDown=new Select(CourseLevel);
	   CourseLevelDropDown.selectByValue("postgraduate_taught");
	   List<List<String>> dataList=dataTable.asLists();
	   driver.findElement(By.cssSelector("input#q")).sendKeys(dataList.get(0).get(1));
	   WebElement searchButton=driver.findElement(By.xpath("//button[@type='submit' and @class='button button--outline bg-white']"));
	   js.executeScript("arguments[0].click();", searchButton);
	}
	@Then("user is navigated to course result page")
	public void user_is_navigated_to_course_result_page() 
	{
		WebElement searchResultText=driver.findElement(By.xpath("//div[@class='programmes__meta']//p"));
		wait.until(ExpectedConditions.visibilityOf(searchResultText));
	    Assert.assertTrue(searchResultText.getText().contains("results found"), "Page Header is not matching");
	}

}
