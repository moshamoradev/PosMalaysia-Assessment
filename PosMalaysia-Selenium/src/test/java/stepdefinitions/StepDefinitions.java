package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.TestRunner;

import utils.WebDriverManagerClass;
import pages.RateCalculatorPage;

import java.util.List;

public class StepDefinitions {

    WebDriver driver = WebDriverManagerClass.getDriver();
    RateCalculatorPage rateCalculatorPage = new RateCalculatorPage();

    @Given("I am on the Pos Malaysia rate calculator page")
    public void i_am_on_the_pos_malaysia_rate_calculator_page() {
        // Navigate to the Pos Malaysia Rate Calculator URL
    	driver.manage().window().maximize();
        driver.get("https://www.pos.com.my/send/ratecalculator");
    }

    @When("I select {string} as the origin country and {string} as the destination country")
    public void i_select_origin_and_destination(String originCountry, String destinationCountry) throws InterruptedException {
        //No need to select From country, Malaysia set as default
        //Enter country and select from To dropdown
        rateCalculatorPage.setToCountry();
    }

    @And("I input {string} as origin country postcode")
    public void iInputAsOriginCountryPostcode(String arg0) {
        //Enter postcode for From section
        rateCalculatorPage.setFromPostcodeField();
    }

    @And("I input {string} as the parcel weight")
    public void iInputAsTheParcelWeight(String arg0) {
        rateCalculatorPage.enterWeight();
    }

    @And("I click Calculate button")
    public void iClickCalculateButton() {
        rateCalculatorPage.clickCalculate();
    }

    @Then("I should see multiple calculated quote rates")
    public void iShouldSeeMultipleCalculatedQuoteRates() throws InterruptedException {
    	Thread.sleep(3000);
        List<WebElement> rateList = rateCalculatorPage.getRates();
        int i =1;
        System.out.println("rateList :" +rateList.size());
        if (rateList.size()>0){
            for (WebElement rateElement : rateList) {
                String rateText = rateElement.getText();
                System.out.println("Service Type : "+ rateText);
            }
        }
        WebDriverManagerClass.quitDriver();
    }


}
