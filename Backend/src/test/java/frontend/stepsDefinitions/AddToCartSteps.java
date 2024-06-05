package frontend.stepsDefinitions;

import frontend.pages.BikesPage;
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
    private String bikeName;
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
        Assert.assertTrue(isProductFound(cartProducts), "The product was not found in the cart");
    }

    private boolean isProductFound(List<WebElement> cartProducts){
        System.out.println("EEEE - " + cartProducts.size());
        for(WebElement product: cartProducts){
            if(product.findElement(By.xpath(".//div[1]/h4")).getText().equals(bikeName)) return true;
        }
        return false;
    }
}


