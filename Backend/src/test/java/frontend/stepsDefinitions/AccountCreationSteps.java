package frontend.stepsDefinitions;

import frontend.pages.LogInPage;
import frontend.pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreationSteps extends BaseSteps{

    private SignUpPage signUpPage;

    private final String FIRST_NAME = "Maciej";
    private final String LAST_NAME = "Mądry";
    private final String EMAIL = "maciek.madry@o2.pl";
    private final String PHONE_NUMBER = "123456789";
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
        signUpPage.writeIntoPhoneField(PHONE_NUMBER);
        signUpPage.writeIntoPasswordField(PASSWORD);
    }

    @When("the user clicks create account button")
    public void userClicksSignUpButton(){
        signUpPage.clickSignUpButton();
    }

    @Then("the user can log in using provided credentials"){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.visitPage();
        logInPage.fillInEmailField(EMAIL);
        logInPage.fillInPasswordField(PASSWORD);

    }

}
