package frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BikesPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div[1]/div/input")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"radix-:rng:\"]")
    private WebElement filterButton;

    @FindBy(xpath = "//*[@id=\"radix-:rnh:\"]/div[3]")
    private WebElement roadFilter;

    @FindBy(xpath = "//*[@id=\"radix-:rnh:\"]/div[4]")
    private WebElement mountainFilter;

    @FindBy(xpath = "//*[@id=\"radix-:rnh:\"]/div[5]")
    private WebElement gravelFilter;

    @FindBy(xpath = "//*[@id=\"radix-:rnh:\"]/div[6]")
    private WebElement cityFilter;

    @FindBy(xpath = "//*[@id=\"radix-:rnh:\"]/div[7]")
    private WebElement kidsFilter;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div[2]/button")
    private WebElement sortByCombobox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]")
    private List<WebElement> allBikes;

    public BikesPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public String getUrl() {
        return "http://localhost:5173/bikes";
    }

    public void selectSortOption(String option){
        Select dropdown = new Select(sortByCombobox);
        dropdown.selectByValue(option);
    }

    public void selectRoadFilter(){
        filterButton.click();
        roadFilter.click();
    }

    public void selectMountainFilter(){
        filterButton.click();
        mountainFilter.click();
    }

    public void selectGravelFilter(){
        filterButton.click();
        gravelFilter.click();
    }

    public void selectCityFilter(){
        filterButton.click();
        cityFilter.click();
    }

    public void selectKidsFilter(){
        filterButton.click();
        kidsFilter.click();
    }

    public void writeToSearchField(String value){
        searchField.clear();
        searchField.click();
        searchField.sendKeys(value);
    }

    public void addBikeToCartWithGivenName(String productName) {
        WebElement product = findBikeByName(productName);
        if (product != null) {
            WebElement addToCartButton = product.findElement(By.xpath(".//button[text()='Add to Cart']")); // Locating the button with specific text
            addToCartButton.click();
        } else {
            throw new NoSuchElementException("Bike with name " + productName + " not found.");
        }
    }

    private WebElement findBikeByName(String bikeName) {
        for (WebElement bike : allBikes) {
            WebElement productNameElement = bike.findElement(By.xpath(".//h3")); // Assuming the product name is located within an <h3> element
            if (bikeName.equals(productNameElement.getText())) {
                return bike;
            }
        }
        return null;
    }
}