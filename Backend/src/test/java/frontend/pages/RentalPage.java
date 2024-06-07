package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RentalPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/h2")
    private WebElement rentPageMainMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/p")
    private WebElement rentPageSecondaryMessage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]")
    private List<WebElement> allRentals;


    public RentalPage(WebDriver driver){
        super(driver);
    }
    @Override
    public String getUrl() {
        return "http:localhost:5173/rental";
    }

    public String getRentPageMainMessage(){
        return rentPageMainMessage.getText();
    }

    public String getRentPageSecondaryMessage(){
        return rentPageSecondaryMessage.getText();
    }

    public void rentABikeWithGivenName(String productName) {
        WebElement product = findBikeByName(productName);
        if (product != null) {
            WebElement addToCartButton = product.findElement(By.xpath(".//button[text()='Rent now']")); // Locating the button with specific text
            addToCartButton.click();
        } else {
            throw new NoSuchElementException("Bike with name " + productName + " not found.");
        }
    }

    private WebElement findBikeByName(String bikeName) {
        for (WebElement bike : allRentals) {
            WebElement productNameElement = bike.findElement(By.xpath(".//h3")); // Assuming the product name is located within an <h3> element
            if (bikeName.equals(productNameElement.getText())) {
                return bike;
            }
        }
        return null;
    }
}
