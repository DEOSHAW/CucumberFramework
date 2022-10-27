package stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IISCStepDefinition extends BaseStepDefinition {
	
	@Given("^IISC portal is open$")
	public void iisc_portal_is_open() throws Exception {
	    driver.get("https://iisc.ac.in/");
	}

	@When("^user navigates to department page$")
	public void user_navigates_to_department_page() throws Exception {
	    WebElement academicsLink=driver.findElement(By.xpath("(//a[contains(@href,'academics')])[1]"));
	    WebElement Department=driver.findElement(By.xpath("//a[text()='Departments']"));
	    actions.moveToElement(academicsLink).pause(Duration.ofSeconds(2)).click(Department).perform();
	    }

	@Then("^list of departments is displayed$")
	public void list_of_departments_is_displayed() throws Exception {
		
	    WebElement element;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Departments']")));
		List<WebElement> departmentList=driver.findElements(By.xpath("//h2[@role='tab']"));
		Iterator<WebElement> itr=departmentList.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
	}



}
