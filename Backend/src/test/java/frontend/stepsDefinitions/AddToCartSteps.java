package frontend.stepsDefinitions;

import frontend.pages.BikesPage;
import frontend.pages.PartsPage;
import frontend.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddToCartSteps extends BaseSteps{

    private BikesPage bikesPage;
    private PartsPage partsPage;
    private String bikeName;
    private String partName;
    @Given("the user is on the bike buying page")
    public void userOnTheBikePage(){
        bikesPage = new BikesPage(driver);
        bikesPage.visitPage();
    }

    @When("the user searches for {string}")
    public void userSearchesFor(String bikeName){
        bikesPage.writeToSearchField(bikeName);
        this.bikeName = bikeName;
    }

    @And("the user adds the bike to the cart")
    public void addBikeToCart(){
        bikesPage.addBikeToCartWithGivenName(bikeName);
    }

    @Then("the bike should be added to the cart")
    public void checkIfBikeInCart(){
        bikesPage.clickShopCartButton();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        List<WebElement> cartProducts = shoppingCartPage.getAllProductsInCart();
        Assert.assertTrue(isProductFound(cartProducts, ".//div[1]/h4\"", bikeName), "The product was not found in the cart");
    }

    @Then("the part should be added to the cart")
    public void checkIfPartInTheCart(){
        partsPage.clickShopCartButton();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        List<WebElement> cartProducts = shoppingCartPage.getAllProductsInCart();
        Assert.assertTrue(isProductFound(cartProducts, ".//div[1]/h4\"", partName), "The product was not found in the cart");
    }
    private boolean isProductFound(List<WebElement> cartProducts, String locator, String expectedValue){
        System.out.println("EEEE - " + cartProducts.size());
        for(WebElement product: cartProducts){
            if(product.findElement(By.xpath(locator)).getText().equals(expectedValue)) return true;
        }
        return false;
    }

    @Given("the user is on the part buing page")
    public void visitPartsPage(){
        partsPage = new PartsPage(driver);
        partsPage.visitPage();
    }

    @When("the user searches for {string} part")
    public void searchForPart(String partName){
        this.partName = partName;
    }

    @And("the user adds the part to the cart")
    public void addPartToTheCart(){
        partsPage.addToCartPartWithGivenName(partName);
    }

}


