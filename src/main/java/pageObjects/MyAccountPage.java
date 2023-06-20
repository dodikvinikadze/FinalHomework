package pageObjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dataObjects.LoginData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class MyAccountPage extends LoginPage {
    WebDriver driver;
  public SelenideElement

            myAccountButton = $(byXpath("//*[text() = 'My Account']")),
            subscriptionInput = $(byXpath("//input[@type='email']")),
            logoutButton = $(byText("Logout")),
            subscribeButton = $(byText("Subscribe"));

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMyAccountPage() {
        myAccountButton.shouldBe(Condition.visible).click();
        sleep(2000);
    }

    public MyAccountPage enterEmailAddress(String emailAddress) {
        subscriptionInput.setValue(LoginData.emailAddress).click();
        return this;
    }

    public MyAccountPage clickSubscribe (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
        return this;
    }

    public MyAccountPage logOut(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return this;
    }

}
