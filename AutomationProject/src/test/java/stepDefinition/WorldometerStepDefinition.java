package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorldometerStepDefinition extends BaseStepDefinition {

    static String populationIndia = "";

    @Given("Worldometer portal is open")
    public void worldometer_portal_is_open() throws InterruptedException {

        driver.get("https://www.worldometers.info/world-population/india-population/");
        Thread.sleep(3000);
    }

    @When("User Extracts India Population")
    public void user_extracts_india_population() {

        By locator = By.xpath("//span[@rel='india-population']/..");

        populationIndia = wait
            .until(d -> {
                try {
                    String text = d.findElement(locator).getText();
                    return text.isBlank() ? null : text;
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            });

        System.out.println("India Population: " + populationIndia);
    }

    @Then("Population is displayed")
    public void population_is_displayed() throws InterruptedException {

        js.executeScript("alert(arguments[0])", "Live population of India is: " + populationIndia);

        Thread.sleep(3000);

        driver.switchTo().alert().accept();
    }
}