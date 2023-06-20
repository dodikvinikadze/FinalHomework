package utils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static dataObjects.LoginData.expectedUrl;

public class ChromeRunner {

   public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Selenide.open("https://ee.ge/");
        driver = WebDriverRunner.getWebDriver();
        driver.manage().window().maximize();
    }

    public void checkURL() {
        if (driver.getCurrentUrl().equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            tearDown();
        }
    }

    @AfterMethod
    public void tearDown() {
         driver.quit();
        }

    }
