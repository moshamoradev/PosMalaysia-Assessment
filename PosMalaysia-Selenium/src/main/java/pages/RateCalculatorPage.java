package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManagerClass;

import java.util.List;

public class RateCalculatorPage {

	// No need to pass WebDriver in constructor, as we'll use WebDriverManagerClass
	private WebDriver driver = WebDriverManagerClass.getDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Locators for elements on the rate calculator page
	private By fromPostcodeField = By.xpath("//input[@type='number' " + "and @formcontrolname='postcodeFrom']");
	private By toCountry = By.xpath("//mat-select-country[@id='country']//input");
	// private By toCountryDropdown = By.xpath("//small[contains(text(),'India')]");
	private By weightField = By.xpath("//input[@type='number' and @formcontrolname='itemWeight']");
	private By calculateBtn = By.linkText("Calculate");
	private By serviceType = By.xpath(
			"//div[@class='bg-white ng-star-inserted']//div[contains(@class,'border-b border-gray-300')]/dl/div/div/dd[normalize-space(text())]");

	// Constructor is now unnecessary, unless you need to initialize specific data
	public RateCalculatorPage() {
		// WebDriver is already initialized via WebDriverManagerClass
	}

	// Methods to interact with elements
	public void setFromPostcodeField() {
		driver.findElement(fromPostcodeField).sendKeys("35600");
		driver.findElement(fromPostcodeField).sendKeys(Keys.RETURN);
	}

	// To Country - India , no Postcode
	public void setToCountry() throws InterruptedException {
		String country = "India";
		// js.executeScript("arguments[0].scrollIntoView();", toCountry);
		driver.findElement(toCountry).click();
		driver.findElement(toCountry).clear();
		driver.findElement(toCountry).sendKeys(country);
		driver.findElement(toCountry).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		// Dropdown section
		// driver.findElement(By.xpath("//div/small[contains(text(),'"+country+"')]")).click();
		// driver.findElement(By.xpath("//div[@role='listbox']//small[contains(text(),'"+country+"')]")).click();
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
	}

	public void enterWeight() {
		String weight = "1";
		driver.findElement(weightField).sendKeys(weight);
		driver.findElement(weightField).sendKeys(Keys.RETURN);
	}

	public void clickCalculate() {
		driver.findElement(calculateBtn).click();
	}

	public List<WebElement> getRates() {
		// return driver.findElements(By.xpath("//div[@class='bg-white
		// ng-star-inserted']//div[contains(@class,'border-b border-gray-300')]"));
		return driver.findElements(serviceType);
	}

	public boolean isRateDisplayed() {
		return driver.findElement(By.id("rateDisplay")).isDisplayed();
	}
}
