import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.WebDriverManagerClass;

@CucumberOptions(
        features = "src/test/resources/",
        glue = "stepdefinitions.StepDefinitions",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
        // Any setup before tests
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver after the tests
        WebDriverManagerClass.quitDriver();
    }
}
