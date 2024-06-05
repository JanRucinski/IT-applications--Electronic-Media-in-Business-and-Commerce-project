package frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[1]/div/a[1]")
    private WebElement exploreButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[1]/div/a[2]")
    private WebElement signInButton;
    public WelcomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://localhost:5173";
    }

    public void clickExploreButton(){
        exploreButton.click();
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
