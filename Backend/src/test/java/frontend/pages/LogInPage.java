package frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(name = "email")
    private WebElement emailInputField;

    @FindBy(name = "password")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/div/div[2]/form/button")
    private WebElement logInButton;

    public LogInPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://localhost:5173/login";
    }

    public void fillInEmailField(String email){
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void fillInPasswordField(String password){
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickLogInButton(){
        logInButton.click();
    }
}
