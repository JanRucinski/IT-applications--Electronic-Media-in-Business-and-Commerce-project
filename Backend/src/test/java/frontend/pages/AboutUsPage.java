package frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]/h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]/p")
    private WebElement story;

    @FindBy(id = "radix-:r75")
    private WebElement question1;

    @FindBy(xpath = "//*[@id=\"radix-:r77:\"]/div")
    private WebElement answer1;

    @FindBy(id = "radix-:r79")
    private WebElement question2;

    @FindBy(xpath = "//*[@id=\"radix-:r79:\"]/div")
    private WebElement answer2;

    @FindBy(id = "radix-:r7d")
    private WebElement question3;

    @FindBy(xpath = "//*[@id=\"radix-:r7d:\"]/div")
    private WebElement answer3;

    @FindBy(id = "radix-:r7h")
    private WebElement question4;

    @FindBy(xpath = "//*[@id=\"radix-:r7h:\"]/div")
    private WebElement answer4;
    @FindBy(id = "radix-:r7l")
    private WebElement question5;

    @FindBy(xpath = "//*[@id=\"radix-:r7l:\"]/div")
    private WebElement answer5;

    @FindBy(id = "radix-:r7p")
    private WebElement question6;

    @FindBy(xpath = "//*[@id=\"radix-:r7p:\"]/div")
    private WebElement answer6;


    public AboutUsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://localhost:5173/about";
    }

    public String getQuestion1(){
        return question1.getText();
    }

    public String getQuestion2(){
        return question2.getText();
    }

    public String getQuestion3(){
        return question3.getText();
    }

    public String getQuestion4(){
        return question4.getText();
    }

    public String getQuestion5(){
        return question5.getText();
    }

    public String getQuestion6(){
        return question6.getText();
    }

    public String getAnswer1(){
        question1.click();
        return answer1.getText();
    }

    public String getAnswer2(){
        question2.click();
        return answer2.getText();
    }

    public String getAnswer3(){
        question3.click();
        return answer3.getText();
    }

    public String getAnswer4(){
        question4.click();
        return answer4.getText();
    }

    public String getAnswer5(){
        question5.click();
        return answer5.getText();
    }

    public String getAnswer6(){
        question6.click();
        return answer6.getText();
    }

}
