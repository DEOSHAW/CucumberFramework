package stepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FalabellaStepDefinition extends BaseStepDefinition {
	static Select countryDropDown;
	static StringBuilder listOfCountries;
	@Given("^Falabella site is open$")
	public void falabella_site_is_open() throws Exception {
	    driver.get("https://investors.falabella.com/English/about-us/default.aspx");
	}

	@When("^user gets the list of countries$")
	public void user_gets_the_list_of_countries() throws Exception {
		WebElement GeoLocations=driver.findElement(By.xpath("//h2[contains(text(),'Our Geographical Footprint')]"));
	    js.executeScript("arguments[0].scrollIntoView();", GeoLocations);
	    WebElement Country=driver.findElement(By.tagName("select"));
	    countryDropDown=new Select(Country);
	    listOfCountries=new StringBuilder();
	    List<WebElement> allOptions=countryDropDown.getOptions();
	   Iterator<WebElement> itr= allOptions.iterator();
	   while(itr.hasNext())
	   {
		   listOfCountries.append(itr.next().getText());
		   listOfCountries.append("\n");
	   }
	    
	}

	@When("^user selects below country$")
	public void user_selects_below_country(DataTable country) throws Exception {
		List<Map<String,String>> countryList=country.asMaps(String.class, String.class);
		countryDropDown.selectByValue(countryList.get(0).get("Country"));
		Thread.sleep(1500);
	}

	@Then("^the list of countries is displayed$")
	public void the_list_of_countries_is_displayed() throws Exception {
	    js.executeScript("alert(arguments[0])", listOfCountries.toString());
	    Thread.sleep(2500);
	    driver.switchTo().alert().accept();
	    Thread.sleep(800);
	}



}
