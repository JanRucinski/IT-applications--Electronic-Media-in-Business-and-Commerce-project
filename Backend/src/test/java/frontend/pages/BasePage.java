package frontend.pages;

import org.checkerframework.checker.units.qual.Force;
import org.hibernate.annotations.processing.Find;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[1]/a/span")
    private WebElement bikeShopLogo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[2]/ul/li[1]")
    private WebElement bikesButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[2]/ul/li[2]")
    private WebElement rentalButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[2]/ul/li[3]")
    private WebElement partsButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[2]/ul/li[4]")
    private WebElement aboutUsButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[2]/ul/li[5]")
    private WebElement contactButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[3]/div[1]/button")
    private WebElement shopCartButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[3]/div[2]/a[1]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/nav[3]/div[2]/a[2]")
    private WebElement signUpButton;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract String getUrl();

    public void visitPage() {
        driver.get(getUrl());
    }


    public void clickBikeShopLogo() {
        bikeShopLogo.click();
    }

    public void clickBikesButton() {
        bikesButton.click();
    }

    public void clickRentalButton() {
        rentalButton.click();
    }

    public void clickPartsButton() {
        partsButton.click();
    }

    public void clickAboutUsButton() {
        aboutUsButton.click();
    }

    public void clickContactButton() {
        contactButton.click();
    }

    public void clickShopCartButton() {
        shopCartButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
