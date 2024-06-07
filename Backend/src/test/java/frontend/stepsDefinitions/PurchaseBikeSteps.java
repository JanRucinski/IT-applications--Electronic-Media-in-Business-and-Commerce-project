package frontend.stepsDefinitions;

import frontend.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class PurchaseBikeSteps extends BaseSteps{

    @Given("the user is logged in")
    public void userHasBikeInTheShoppingCart(){
        String name = "Maciej";
        String lastName = "Madry";
        String email = "maciek.madry@o2.pl";
        String username = "Maciej";
        String password = "password";
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.visitPage();
        signUpPage.writeIntoFirstNameField(name);
        signUpPage.writeIntoLastNameField(lastName);
        signUpPage.writeIntoEmailField(email);
        signUpPage.writeIntoUsernameField(username);
        signUpPage.writeIntoPasswordField(password);
        signUpPage.clickSignUpButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/login"));
        LogInPage logInPage = new LogInPage(driver);

        logInPage.fillInUsernameField(username);
        logInPage.fillInPasswordField(password);
        logInPage.clickLogInButton();

    }

    @And("the user has a bike in a cart")
    public void addProductToTheCart(){
        BikesPage bikesPage = new BikesPage(driver);
        bikesPage.writeToSearchField("Trek Mountain Bike");
        bikesPage.addBikeToCartWithGivenName("Trek Mountain Bike");
    }

    @When("the user click the checkout button")
    public void clickCheckoutButton(){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickShopCartButton();
        shoppingCartPage.clickCheckoutButton();
    }

    @And("the user provides correct data")
    public void fillInData(){
        String name = "Maciej Madry";
        String number = "1249 103014";
        String cvc = "012";
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.fillInName(name);
        paymentPage.fillInNumber(number);
        paymentPage.fillInCVC(cvc);
        paymentPage.chooseCardPayment();
        paymentPage.selectMonth("march");
        paymentPage.selectYear("2025");
        paymentPage.clickContinue();

    }

    @Then("the user should receive information about successful purchase")
    public void userReceivesConfirmationMessage(){
        PaymentPage paymentPage = new PaymentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(paymentPage.getConfirmationMessage()));
        Assert.assertEquals(paymentPage.getConfirmationMessage().getText(), "Order created successfully");
    }
}