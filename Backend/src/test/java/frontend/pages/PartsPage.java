package frontend.pages;

import org.hibernate.annotations.processing.Find;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PartsPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/input")
    private WebElement searchInputField;

    @FindBy(id = "radix-:r6a:")
    private WebElement filterButton;

    @FindBy(xpath = "//*[@id=\"radix-:r6b:\"]/div[3]")
    private WebElement framesFilter;

    @FindBy(xpath = "//*[@id=\"radix-:r6b:\"]/div[4]")
    private WebElement wheelsFilter;

    @FindBy(xpath = "//*[@id=\"radix-:r6b:\"]/div[5]")
    private WebElement drivetrainFilter;

    @FindBy(xpath = "//*[@id=\"radix-:r6b:\"]/div[6]")
    private WebElement brakesFilter;

    @FindBy(xpath = "//*[@id=\"radix-:r6b:\"]/div[7]")
    private WebElement suspensionFilter;

    @FindBy(xpath = "//*[@id=\"radix-:r6b:\"]/div[8]")
    private WebElement accessoriesFilter;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]")
    private List<WebElement> allParts;


    public PartsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http:localhost:5173/parts";
    }

    public void clickFramesFilter(){
        filterButton.click();
        framesFilter.click();
    }

    public void clickWheelsFilter(){
        filterButton.click();
        wheelsFilter.click();
    }

    public void clickDrivetrainFilter(){
        filterButton.click();
        drivetrainFilter.click();
    }

    public void clickBrakesFilter(){
        filterButton.click();
        drivetrainFilter.click();
    }

    public void clickSuspensionFilter(){
        filterButton.click();
        suspensionFilter.click();
    }

    public void clickAccessoriesFilter(){
        filterButton.click();
        accessoriesFilter.click();
    }

    public void addToCartPartWithGivenName(String productName) {
        WebElement product = findPartByName(productName);
        if (product != null) {
            WebElement addToCartButton = product.findElement(By.xpath(".//button[text()='Add to cart']")); // Locating the button with specific text
            addToCartButton.click();
        } else {
            throw new NoSuchElementException("Part with name " + productName + " not found.");
        }
    }

    private WebElement findPartByName(String bikeName) {
        for (WebElement part : allParts) {
            WebElement productNameElement = part.findElement(By.xpath(".//h3")); // Assuming the product name is located within an <h3> element
            if (bikeName.equals(productNameElement.getText())) {
                return part;
            }
        }
        return null;
    }



}
