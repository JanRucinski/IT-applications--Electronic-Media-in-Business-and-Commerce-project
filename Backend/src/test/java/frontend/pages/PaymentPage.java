package frontend.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/div/div[2]/div[1]/div[1]/label")
    private WebElement cardChoice;

    @FindBy(id = "name")
    private WebElement nameOnTheCard;

    @FindBy(id = "number")
    private WebElement cardNumber;

    @FindBy(id = "month")
    private WebElement monthCombobox;

    @FindBy(id = "year")
    private WebElement yearCombobox;

    @FindBy(id = "cvc")
    private WebElement cvcNumber;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/div/div[3]/button")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/ol/li")
    private WebElement confirmationMessage;

    public PaymentPage(WebDriver driver){
        super(driver);
    }
    @Override
    public String getUrl() {
        return null;
    }

    public void fillInName(String name){
        nameOnTheCard.clear();
        nameOnTheCard.sendKeys(name);
    }

    public void fillInNumber(String number){
        cardNumber.clear();
        cardNumber.sendKeys(number);
    }

    public void fillInCVC(String cvc){
        cvcNumber.clear();
        cvcNumber.sendKeys(cvc);
    }

    public void selectMonth(String month){
        monthCombobox.sendKeys(month);
    }

    public void selectYear(String year){
        yearCombobox.sendKeys(year);
    }

    public void chooseCardPayment(){
        cardChoice.click();
    }

    public WebElement getConfirmationMessage(){
        return confirmationMessage;
    }

    public void clickContinue(){
        continueButton.click();
    }
}
