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

    @FindBy(xpath = "//*[@id=\":r7t:-form-item\"]")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//*[@id=\":r7v:-form-item\"]")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//*[@id=\":r81:-form-item\"]")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[@id=\":r83:-form-item\"]")
    private WebElement messageInputField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]/div/div[2]/form/button")
    private WebElement sendMessageButton;

    public ContactPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
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
}
