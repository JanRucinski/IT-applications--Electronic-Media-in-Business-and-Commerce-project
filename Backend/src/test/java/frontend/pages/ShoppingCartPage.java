package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"radix-:rd1:\"]/div[2]/div/span")
    WebElement totalPrice;

    @FindBy(xpath = "/html/body/div[2]/div/ul")
    WebElement allProductsInCart;

    @FindBy(xpath = "//*[@id=\"radix-:rd1:\"]/div[2]/div/button")
    WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public List<WebElement> getAllProductsInCart(){
        System.out.println(allProductsInCart.isDisplayed());
        return allProductsInCart.findElements(By.xpath(".//li"));
    }
}