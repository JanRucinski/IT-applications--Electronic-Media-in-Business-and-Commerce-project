package frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]/h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[2]/p")
    private WebElement story;

    @FindBy(id = "radix-:rb:")
    private WebElement question1;

    @FindBy(xpath = "//*[@id=\"radix-:rb:\"]/div")
    private WebElement answer1;

    @FindBy(id = "radix-:rf:")
    private WebElement question2;

    @FindBy(xpath = "//*[@id=\"radix-:rf:\"]/div")
    private WebElement answer2;

    @FindBy(id = "radix-:rj:")
    private WebElement question3;

    @FindBy(xpath = "//*[@id=\"radix-:rj:\"]/div")
    private WebElement answer3;

    @FindBy(id = "radix-:rn:")
    private WebElement question4;

    @FindBy(xpath = "//*[@id=\"radix-:rn::\"]/div")
    private WebElement answer4;
    @FindBy(id = "radix-:rr:")
    private WebElement question5;

    @FindBy(xpath = "//*[@id=\"radix-:rr:\"]/div")
    private WebElement answer5;

    @FindBy(id = "radix-:rv:")
    private WebElement question6;

    @FindBy(xpath = "//*[@id=\"radix-:rv:\"]/div")
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
