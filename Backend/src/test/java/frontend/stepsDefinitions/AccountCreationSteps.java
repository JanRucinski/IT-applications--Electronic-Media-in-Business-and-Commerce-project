package frontend.stepsDefinitions;

import frontend.pages.LogInPage;
import frontend.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountCreationSteps extends BaseSteps{

    private SignUpPage signUpPage;

    private final String FIRST_NAME = "Test1";
    private final String LAST_NAME = "Test2";
    private final String EMAIL = "maciek.madry@o2.pl";
    private final String USERNAME = "Test1";
    private final String PASSWORD = "password";

    @Given("the user is on the sign-up page")
    public void userOnSignUpPage(){
        signUpPage = new SignUpPage(driver);
        signUpPage.visitPage();
    }

    @And("the user has filled in all of the sing-up form fields")
    public void fillInAllFormData(){
        signUpPage.writeIntoFirstNameField(FIRST_NAME);
        signUpPage.writeIntoLastNameField(LAST_NAME);
        signUpPage.writeIntoEmailField(EMAIL);
        signUpPage.writeIntoUsernameField(USERNAME);
        signUpPage.writeIntoPasswordField(PASSWORD);
    }

    @When("the user clicks create account button")
    public void userClicksSignUpButton(){
        signUpPage.clickSignUpButton();
    }

    @Then("the user logs in using provided credentials")
    public void userLogsIntoWebsite(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/login"));

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillInUsernameField(USERNAME);
        logInPage.fillInPasswordField(PASSWORD);
        logInPage.clickLogInButton();
        String expectedURL = "http://localhost:5173/bikes";

        wait.until(ExpectedConditions.urlToBe(expectedURL));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

}
