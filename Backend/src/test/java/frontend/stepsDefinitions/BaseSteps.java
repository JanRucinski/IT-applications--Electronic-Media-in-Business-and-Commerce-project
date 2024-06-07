package frontend.stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseSteps {
    protected WebDriver driver;

    public BaseSteps(){
        // Instantiate WebDriver
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

    }
}
