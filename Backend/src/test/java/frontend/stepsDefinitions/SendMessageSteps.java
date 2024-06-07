package frontend.stepsDefinitions;

import frontend.pages.ContactPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import java.time.Duration;

public class SendMessageSteps extends BaseSteps{
    String FIRST_NAME = "Maciej";
    String LAST_NAME = "Mądry";
    String EMAIL_ADDRESS = "maciek.madry@o2.pl";
    String MESSAGE = "This is a test stage";
    ContactPage contactPage = new ContactPage(driver);
    @Given("the user is on the contact page")
    public void userOnTheContactPage(){
        contactPage.visitPage();
    }

    @And("the user has filled in all the form fields")
    public void userFillInAllData(){
        contactPage.fillInFirstName(FIRST_NAME);
        contactPage.fillInLastName(LAST_NAME);
        contactPage.fillInEmailAddress(EMAIL_ADDRESS);
        contactPage.fillInMessage(MESSAGE);
    }

    @When("the user clicks send message button")
    public void clickSendMessageButton(){
        contactPage.clickSendMessageButton();
    }

    @Then("the success popup should be shown")
    public void verifySuccessPopup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactPage.getSuccessfulNotification()));
        Assert.isTrue(contactPage.getSuccessfulNotification().isDisplayed(), "The form wasn't filled in correctly");
    }

    @But("the user forgot about filling in an email form")
    public void forgetAboutEmailField(){
        contactPage.getEmailErrorMessage().clear();
    }

    @Then("the error about filling form should be shown")
    public void verifyEmailErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactPage.getEmailErrorMessage()));
        Assert.isTrue(contactPage.getEmailErrorMessage().isDisplayed(), "The email input has been filled in");
    }
}
