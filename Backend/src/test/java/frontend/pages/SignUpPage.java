package frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "phone")
    private WebElement phoneField;

    @FindBy(name = "password")
    private WebElement passwordfield;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/div/div[2]/form/button")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver){
        super(driver);
    }
    @Override
    public String getUrl() {
        return "http://localhost:5173/sign-up";
    }

    public void writeIntoFirstNameField(String firstName){
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void writeIntoLastNameField(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void writeIntoEmailField(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void writeIntoPhoneField(String phone){
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void writeIntoPasswordField(String password){
        passwordfield.clear();
        passwordfield.sendKeys(password);
    }

    public void clickSignUpButton(){
        signUpButton.click();
    }
}
