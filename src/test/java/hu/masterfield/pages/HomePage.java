package hu.masterfield.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span")
    WebElement acceptButton;




    public HomePage(WebDriver driver) {
        super (driver);


    }
    public void openPage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    public void acceptCookies() {
        acceptButton.click();
    }

    public  SearchPage search (String word) {



        return new SearchPage(driver);
    }
}













