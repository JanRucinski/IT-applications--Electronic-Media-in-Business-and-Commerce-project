package frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/div/div[1]/div/address")
    private WebElement addressText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/div/div[2]/div")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/div/div[3]/div/a")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[1]/div/div/div[4]/div/p")
    private WebElement workingHours;

    @FindBy(xpath = "//*[@id=\":rb:-form-item\"]")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//*[@id=\":rd:-form-item\"]")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//*[@id=\":rf:-form-item\"]")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[@id=\":rh:-form-item\"]")
    private WebElement messageInputField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/form/button")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/ol/li")
    private WebElement successfulNotification;

    @FindBy(xpath = "//*[@id=\":r1r:-form-item-message\"]")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//*[@id=\":r1t:-form-item-message\"]")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//*[@id=\":r1v:-form-item-message\"]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//*[@id=\":r21:-form-item-message\"]")
    private WebElement messageFieldErrorMessage;

    public ContactPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://localhost:5173/contact";
    }

    public String getAddress(){
        return addressText.getText();
    }

    public String getPhoneNumber(){
        return phoneNumber.getText();
    }

    public String getEmail(){
        return mailAddress.getText();
    }

    public String getWorkingHours(){
        return workingHours.getText();
    }

    public void fillInFirstName(String name){
        firstNameInputField.clear();
        firstNameInputField.sendKeys(name);
    }

    public void fillInLastName(String lastName){
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
    }

    public void fillInEmailAddress(String emailAddress){
        emailInputField.clear();
        emailInputField.sendKeys(emailAddress);
    }

    public void fillInMessage(String message){
        messageInputField.clear();
        messageInputField.sendKeys(message);
    }

    public void clickSendMessageButton(){
        sendMessageButton.click();
    }

    public WebElement getSuccessfulNotification(){
        return successfulNotification;
    }

    public WebElement getEmailErrorMessage() { return emailErrorMessage;}
}
