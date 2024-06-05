package frontend.stepsDefinitions;

import frontend.pages.BasePage;
import frontend.pages.ContactPage;
import frontend.pages.WelcomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ViewContactInfoSteps extends BaseSteps {

    String EXPECTED_ADRESS = "123 Street 256 House";
    String EXPECTED_PHONENUMBER = "+123 456 7890";
    String EXPECTECD_EMAIL = "support@bikeshop.com";
    String EXPECTED_WORKING_HOURS = "Mon - Fri: 9:00 - 19:00";

    @Given("the user is on any page")
    public void goToWelcomePage(){
        WelcomePage currentPage = new WelcomePage(driver);
        currentPage.visitPage();
    }

    @When("the user clicks Contact button in the header menu")
    public void clickContactButton(){
        WelcomePage currentPage = new WelcomePage(driver);
        currentPage.clickContactButton();
    }

    @Then("the user sees the contact information of the shop")
    public void checkShopInformation(){
        ContactPage contactPage = new ContactPage(driver);
        String address = contactPage.getAddress();
        String phoneNumber = contactPage.getPhoneNumber().substring(8);
        String workingHours = contactPage.getWorkingHours();
        String email = contactPage.getEmail();
        Assert.assertEquals(address,EXPECTED_ADRESS, "Address doesn't match expected value");
        Assert.assertEquals(workingHours, EXPECTED_WORKING_HOURS, "Working hours don't match expected value");
        Assert.assertEquals(email, EXPECTECD_EMAIL, "Email doesn't match expected value");
        Assert.assertEquals(phoneNumber, EXPECTED_PHONENUMBER, "Phone number doesn't match expected value");
    }
}
