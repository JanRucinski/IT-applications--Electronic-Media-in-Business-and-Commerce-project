package frontend;


import frontend.pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class AcceptanceTests {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        // Instantiate WebDriver
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

    }
}
