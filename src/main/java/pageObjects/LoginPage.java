package pageObjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dataObjects.LoginData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;



public class LoginPage  {

    public  SelenideElement

            languageEng = $(byLinkText("eng")),
            usernameInput = $(byName("userName")),
            passwordInput = $(byXpath("//input[@type='password']")),
            loginButton = $(byXpath("//*[text() = 'Login']")),
            signInButton = $(byClassName("btn-darkred"));




    public void changeSiteLanguage() {
        languageEng.shouldBe(Condition.visible).click();
    }

    public void getLoginPage() {
        loginButton.should(Condition.visible).click();
    }

    public LoginPage enterEmail(String emailAddress) {
         usernameInput.setValue(LoginData.emailAddress).click();
         return this;
     }

     public LoginPage enterPassword(String password) {
         passwordInput.setValue(LoginData.password);
         return this;
     }

     public LoginPage clickOnSignInButton(WebDriver driver) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
         return this;
     }


}

