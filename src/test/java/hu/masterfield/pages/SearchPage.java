package hu.masterfield.pages;

import hu.masterfield.cucumber.steps.TescoSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import static hu.masterfield.pages.BasePage.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPage {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @Before   // cucumber annotáció
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();

        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = TescoSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);

        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900)); // ...selenium.Dimension
    }
    @After
    public static void cleanup() {

        driver.quit();
    }



    @When("search a {string} wich exist")
    public void searchAWichExist(String product) {
        WebElement searchButton = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"search-input")));

        searchButton.click();
        searchButton.sendKeys(product);
        WebElement searchIcon = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"search-input")));
        searchIcon.click();


        HomePage homePage = new HomePage(driver);
        assertEquals("https://bevasarlas.tesco.hu/groceries/hu-HU", homePage.getURL());
        SearchPage searchPage = homePage.search(product);


    }

    @Then("it shows the result")
    public void itShowsTheResult() {

    }

    @When("search a {string} wich does not exist")
    public void searchAWichDoesNotExist(String arg0) {
    }

    @Then("it do not shows the result")
    public void itDoNotShowsTheResult() {
    }
}
