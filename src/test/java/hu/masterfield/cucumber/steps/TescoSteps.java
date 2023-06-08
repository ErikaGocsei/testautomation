package hu.masterfield.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

public class TescoSteps {

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

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900)); // ...selenium.Dimension
    }
    @After
    public static void cleanup() {
        driver.quit();
    }




    @Given("open main page")
    public void openMainPage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    @And("accept cookies")
    public void acceptCookies() {
        //#sticky-bar-cookie-wrapper > span > div > div > div.base-components__BaseElement-sc-1mosoyj-0.styled__ButtonContainer-sc-1vnc1v2-4.oznwo.ksIudk.beans-cookies-notification__buttons-container > form:nth-child(1) > button > span > span
        ////*[@id="sticky-bar-cookie-wrapper"]/span/div/div/div[2]/form[1]/button/span/span
        WebElement buttonAccept = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span")));

    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String lang) {

        //ha maygar az oldal és megjelenik az english felirat:
        //#utility-header-language-switch-link > span > span
        ////*[@id="utility-header-language-switch-link"]/span/span
        //ha angol az oldal és megjelenik az magyar felirat:
        //#utility-header-language-switch-link > span > span
        ////*[@id="utility-header-language-switch-link"]/span/span

        WebElement languagetable = wait.until(driver -> driver.findElement(By.id("languagetable")));

        if(lang.equals("magyar")) {
            driver.findElement(By.cssSelector("#languagetable > span:nth-child(1)")).click();
        }

        if(lang.equals("english")) {
            driver.findElement(By.cssSelector("#languagetable > span:nth-child(2)")).click();
        }


    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String arg0) {
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String arg0) {
    }
}
