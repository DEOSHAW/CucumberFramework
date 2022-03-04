package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MultiSelectStepDefinition extends BaseStepDefinition {
	StringBuilder carOptions;
	@Given("^MultiSelect portal is open$")
	public void multiselect_portal_is_open() throws Exception {
	    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
	}

	@Given("^user gets the list of all the options from the car List$")
	public void user_gets_the_list_of_all_the_options_from_the_car_List() throws Exception {
		driver.switchTo().frame("iframeResult");
	   WebElement carList=driver.findElement(By.tagName("select"));
	   Select carsMultiList=new Select(carList);
	   List<WebElement> cars=carsMultiList.getOptions();
	   carOptions=new StringBuilder();
	   for(WebElement car:cars)
	   {
		   carOptions.append(car.getAttribute("value"));
		   carOptions.append("\n");
	   }
	}

	@Then("^the list of cars is displayed$")
	public void the_list_of_cars_is_displayed() throws Exception {
		System.out.println(carOptions);
	}


}
